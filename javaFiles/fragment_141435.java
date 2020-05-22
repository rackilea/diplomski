import processing.opengl.*;
float r1, r2;
PImage tex;
void setup()
{
  size(800, 800, OPENGL);
 for (int j=0; j<numAgents; j++)
    agents[j]=new agent();
  for (int i=0; i<numMovers; i++)
    movers[i]=new Mover();
  tex = loadImage("yourImage.png");
  textureMode(NORMALIZED);
  smooth();
}
void draw()
{
  background(0);

  for (int i=0; i<numMovers; i++)
  {
    movers[i].update();
    movers[i].checkEdges();
    movers[i].display();
    int closestAgentNumber=-1;
    for (int j=0; j<numAgents; j++)
    {
      agents[j].checkEdges();
      agents[j].display();

      agents[j].update();
      agents[j].repel();

      float d = dist(agents[j].location.x, agents[j].location.y, movers[i].location.x, movers[i].location.y );

      if (d < 100) {
        closestAgentNumber=j; 
      }
      if (d<200)
      {
        agents[j].behaviour=1;
        agents[j].follow(movers[i].location.x, movers[i].location.y);
        movers[i].hit = true;
      }
      else if (d>100) {
        movers[i].hit = false;

        agents[j].behaviour=0;
      }

    }
  }
}
int numAgents= 100;
agent[]agents =new agent[numAgents];

class agent
{
  PVector location;
  PVector velocity;
  PVector acceleration;
  float topspeed;
  float r1, r2;
  // boolean connect=false;
  int behaviour;
  boolean follow=false;
  //boolean follow= false;
  agent()
  {
    float speed=800;

    if (behaviour==0)
    {

      location= new PVector(random(0, speed), random(0, speed));
      velocity= new PVector(1, 1);
      acceleration= new PVector( random(-0.01, 0.01), random(-0.01, 0.01));
      acceleration.normalize();
      topspeed=5;
    }
    else if (behaviour==1)
    {


      // connect=true;
    }
    // Set to acceleration
  }
  void follow(float x, float y)
  {
    if (follow==true)
    { 

      // follow==true;
      // Our algorithm for calculating acceleration:
      PVector moverPos = new PVector(x, y);
      PVector dir = PVector.sub(moverPos, location);  // Find vector pointing towards mouse
      dir.normalize();     // Normalize
      dir.mult(4);       // Scale 
      acceleration = dir;
    }
  }
  void update()
  {
    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);
  }

  void display()
  {
    pushMatrix();
    translate(location.x, location.y);
    if (behaviour==1)
    {
      fill(255, 0, 0);
    }
    else if ( behaviour==0)
    {
      fill(255, 255, 255);
    }
    ellipse(0, 0, 4, 4);
    strokeWeight(1);

    popMatrix();
  }

  void checkEdges() 
  {

    if (location.x < 0) {
      location.x = 0;
      velocity.x *= -1;
      acceleration.mult(0.001);
    }
    if (location.x > 800) {
      location.x = 800;
      velocity.x *= -1;
      acceleration.mult(0.001);
    }
    if (location.y < 0) {
      location.y = 0;
      velocity.y *= -1;
      acceleration.mult(0.001);
    }
    if (location.y > 800) {
      location.y = 800;
      velocity.y *= -1;
      acceleration.mult(0.001);
    }
  }
  void repel()
  {

    for (int i=0; i<numAgents; i++) {

      if ((agents[i].behaviour==1))

      {
        int k;

        k=1;
        for (int j=0; j<numAgents; j++)
        {


          //--------------
          // float dm = agents[i].location.dist(agents[k].location);
          float dm = dist(agents[j].location.x, agents[j].location.y, agents[i].location.x, agents[i].location.y);
          if (dm < 50) {
            agents[i].velocity.mult(-1);
            agents[i].acceleration.mult(0.5);
            agents[j].velocity.mult(-1);
            agents[j].acceleration.mult(0.5);
          }
          else if (behaviour==0)
          {
            agents[i].velocity.mult(1);
            agents[j].velocity.mult(1);
          }



          //float dm = dist(agents[i].location.x, agents[i].location.y, agents[j].location.x, agents[j].location.y);
          // float dm = agents[i].location.dist(agents[j].location);
          // int clr=(int) map (dm,0,100,200,0);
          if (dm<180 && dm>100)


          {
            if ( k<2)
            {
              //println(dm);
              //stroke(255,0,0);
              r1 = agents[j].location.x;
              r2 = agents[j].location.y;

              k=k+1;
            }
            else
            {
              //fill(random(255),random(255),random(255),random(0,20));

              //stroke(0,50);
              // texture(A);

              //fill(random(0,255),random(0,255),random(0,255),random(0, 40));

              // stroke(140, 50);  
              fill(random(0, 255), random(0, 255), random(0, 255), random(0, 10));

              stroke(140, 50);
              beginShape();
              tint(255,127);  
              texture(tex);
              vertex(agents[i].location.x, agents[i].location.y,0.0,0.0);//aditional u,v coordinates 0,0 - top left of texture
              vertex(r1, r2,1.0,0.0);//top right texture coordinate
              vertex(agents[j].location.x, agents[j].location.y,1.0,1.0);//bottom right texture coordinat
              endShape(CLOSE);
              j=300;
            }
          }
        }
        /*void triangulate()
         {

         fill(random(0, 255), random(0, 255), random(0, 255), random(0, 40));

         stroke(140, 50);
         for (int i=0; i<numAgents; i++)
         {
         //gens[i].connect==true)
         //if(! agents[i].connect)

         if (agents[i].behaviour==1)

         {
         //println(agents[i]);
         int k;

         k=1;

         for (int j=0; j<numAgents; j++)
         {
         float dm = dist(agents[i].location.x, agents[i].location.y, agents[j].location.x, agents[j].location.y);
         // float dm = agents[i].location.dist(agents[j].location);
         // int clr=(int) map (dm,0,100,200,0);
         if (dm<180 && dm>100)

         {
         if ( k<2)
         {
         //println(dm);
         //stroke(255,0,0);
         }
         }
         }
         }*/
      }
    }
  }
}
int numMovers= 1;
Mover[]movers= new Mover[numMovers];

class Mover
{

  PVector location;
  PVector velocity;
  PVector acceleration;
  float topspeed;
  boolean hit = false;

  Mover() 
  {
    float spead = 800;
    location = new PVector(random(0,spead),random(0,spead));
    velocity = new PVector(0,0);
    acceleration = new PVector(random(-1,1),random(-1,1));//random initial acceleration
    topspeed = 4;
  }



  void update() 
  {
    // Motion 101!  Velocity changes by acceleration.  Location changes by velocity.
    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);
  }


  void display()
  {
    pushMatrix();
  translate(location.x,location.y);
  //fill(102,0,155,random(120,160));
  //fill(32,225,245,127 + sin(frameCount*.01) * 127);
  if(hit) fill(255,10,96,120);
  else   
  fill(3,225,190,random(50,127));
  ellipse(0,0,30,30);
  noStroke();
  popMatrix();
  }


  void checkEdges() 
  {

    if(location.x < 0){
      location.x = 0;
      velocity.x *= -1;
      acceleration.mult(0.001);
    }
    if(location.x > 800){
      location.x = 800;
      velocity.x *= -1;
      acceleration.mult(0.001);

    }
    if(location.y < 0){
      location.y = 0;
      velocity.y *=- 1;
      acceleration.mult(0.001);

    }
    if(location.y > 800){
      location.y = 800;
      velocity.y *= -1;
      acceleration.mult(0.001);

    }




  }

}