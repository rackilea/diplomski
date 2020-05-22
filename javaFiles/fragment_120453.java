void setup()
  {
    size(500,500);
    frameRate(15);
  }

  void draw()
  { 
    background(0); //fills background with black
    noStroke(); //gets rid of stroke

    int circlenumber = 999;// determines how many circles will be drawn 
    float radius = 5; //radius of each small circle
    float area = (radius) * (radius) * PI; //area of each small circle
    float total = 0; //total areas of circles already drawn
    float offset = frameCount * 0.01; //HOW DOES IT WORK & WHAT DOES IT DO

    for (int i = 1; i <= circlenumber; ++i) { // loops through all of the circles making up the pattern

      float angle = i*19 + offset; //HOW DOES IT WORK & WHAT DOES IT DO
      total += area; // adds up the areas of all the small circles that have already been drawn
      float amplitude = sqrt( total / PI ); //amplitude of trigonometric spiral
      float x = width/2 + cos(angle) * amplitude;//HOW DOES IT WORK & WHAT DOES IT DO

      float hue = i;//determines circle color based on circle number
      fill(hue, 44, 255);//fills circle with that color

      stroke(hue,44,255);
      if(i%30 == 0)
          line(0,i,width,i);

      ellipse(x, i, radius*2, radius*2); //draws circle
    }
  }