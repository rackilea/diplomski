public void setup() {

  size(800,600);
  frameRate(150);

}

boolean down = false;
float R = 255;
float G = 255;
float B = 0;
float incrementoR = +1;
float incrementoG = +1;
float incrementoB = +1;
float mincol = 0, maxcol = 255;

public void draw() {

    background (1,255,1);

    if(down) {

        //update increments prior to applying them
        if(R > maxcol) incrementoR = -1;
        if(R < mincol) incrementoR = random(2);

        if(G > maxcol) incrementoG = -1;  
        if(G < mincol) incrementoG = +5;

        if(B > maxcol) incrementoB = -1; 
        if(B < mincol) incrementoB = +10;

        //apply increments
        R += incrementoR;
        G += incrementoG;
        B += incrementoB;

        println("\nFramecount: "+frameCount);
        println("The current framerate is: "+frameRate);
        background(R,G,B);
        }

     fill(127);   
     text("R:"+(int)R+"\tG:"+(int)G+"\tB:"+(int)B,15,15);

    }


public void mousePressed() {
    down = true;
}