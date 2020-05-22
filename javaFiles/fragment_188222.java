import ddf.minim.analysis.*;
import ddf.minim.*;

//audio
Minim minim;
AudioInput microphone;
FFT fftLog;
//audio-driven mesh
Waveform audio3D;
//DXF output
boolean record;
PrintWriter out;

void setup()
{
  size(1250,750,P3D); //screen proportions
  noStroke();
  minim = new Minim(this);
  microphone = minim.getLineIn(Minim.STEREO, 4096);

  background(255);

  fftLog = new FFT(microphone.bufferSize(),microphone.sampleRate());
  fftLog.logAverages(1,2);  //adjust numbers to adjust spacing;
  float w = float (width/fftLog.avgSize());
  float x = w;
  float y = 0;
  float z = 50;
  float radius = 10;
  audio3D = new Waveform(x,y,z,radius);
}
void draw()
{
  background(0);
  directionalLight(126,126,126,sin(radians(frameCount)),cos(radians(frameCount)),1);
  ambientLight(102,102,102);

  if (frameCount>200)
  {
    for(int i = 0; i < fftLog.avgSize(); i++){
      float zoom = 1;
      float jitter = (fftLog.getAvg(i)*2);
      //println(jitter);
      PVector foc = new PVector(audio3D.x+jitter, audio3D.y+jitter, 0);
      PVector cam = new PVector(zoom, zoom, -zoom);
      camera(foc.x+cam.x+50,foc.y+cam.y+50,foc.z+cam.z,foc.x,foc.y,foc.z,0,0,1);
    }
  }
  //update FFT
  fftLog.forward(microphone.mix);
  //update 3D mesh
  audio3D.update();
  audio3D.textdraw();
  audio3D.plotTrace();
}
void stop(){
  microphone.close();
  minim.stop();
  super.stop();
}
class Waveform
{
  float x,y,z;
  float radius;

  PVector[] pts = new PVector[fftLog.avgSize()];

  PVector[] trace = new PVector[0];

  Waveform(float incomingX, float incomingY, float incomingZ, float incomingRadius)
  {
    x = incomingX;
    y = incomingY;
    z = incomingZ;
    radius = incomingRadius;
  }
  void update()
  {
    plot();
  }
  void plot()
  {
    for(int i = 0; i < fftLog.avgSize(); i++)
    {
      int w = int(width/fftLog.avgSize());

      x = i*w;
      y = frameCount*5;
      z = height/4-fftLog.getAvg(i)*4; //change multiplier to reduces height default '10'

      stroke(0);
      point(x, y, z);
      pts[i] = new PVector(x, y, z);
      //increase size of array trace by length+1
      trace = (PVector[]) expand(trace, trace.length+1);
      //always get the next to last
      trace[trace.length-1] = new PVector(pts[i].x, pts[i].y, pts[i].z);
    }
  }
  void textdraw()
  {
    for(int i =0; i<fftLog.avgSize(); i++){
      pushMatrix();
      translate(pts[i].x, pts[i].y, pts[i].z);
      rotateY(PI/2);
      rotateZ(PI/2);

      fill(255,200);
      text(round(fftLog.getAvg(i)*100),0,0,0);
      popMatrix();
    }
  }
  void plotTrace()
  {
    stroke(255,80);
    int inc = fftLog.avgSize();

    if(record){//init dxf writing
      out = createWriter("output.dxf");
      out.println("0");
      out.println("SECTION");
      out.println("2");
      out.println("ENTITIES");
    }

    for(int i=1; i<trace.length-inc; i++)
    {
      if(i%inc != 0)
      {
        beginShape(TRIANGLE_STRIP);

        float value = (trace[i].z*100);
        float m = map(value, -500, 20000, 0, 255);
        fill(m*2, 125, -m*2, 140);
        vertex(trace[i].x, trace[i].y, trace[i].z);
        vertex(trace[i-1].x, trace[i-1].y, trace[i-1].z);
        vertex(trace[i+inc].x, trace[i+inc].y, trace[i+inc].z);
        vertex(trace[i-1+inc].x, trace[i-1+inc].y, trace[i-1+inc].z);
        endShape(CLOSE);

        if(record){//write each quad face to DXF file


          out.println("  0 ");
          out.println("3DFACE");
          out.println(" 10");   // first x
          out.println(trace[i].x);
          out.println(" 20 ");  // first y
          out.println(trace[i].y);
          out.println(" 30 ");  // first z
          out.println(trace[i].z);
          out.println(" 11");   // second x
          out.println(trace[i-1].x);
          out.println(" 21 ");  // second y
          out.println(trace[i-1].y);
          out.println(" 31 ");  // second z
          out.println(trace[i-1].z);
          out.println(" 12");   // third x
          out.println(trace[i-1+inc].x);
          out.println(" 22 ");  // third y
          out.println(trace[i-1+inc].y);
          out.println(" 32 ");  // third z
          out.println(trace[i-1+inc].z);
          out.println(" 13");   // fourth x
          out.println(trace[i+inc].x);
          out.println(" 23 ");  // fourth y
          out.println(trace[i+inc].y);
          out.println(" 33 ");  // fourth z
          out.println(trace[i+inc].z);


        }

      }
    }

      if(record)//finish writing
      {

        out.println("  0 ");
        out.println("ENDSEC");
        out.println("  0");
        out.println("EOF");
        out.flush();
        out.close();

        record = false;
        println("wrote DXF!");
      }

  }
}
void keyPressed()
{
  if (key == 'r') record = true;
}