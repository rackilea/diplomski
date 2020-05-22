class LightAlg {
  int greenX, greenY = 50;   // Alphas of Green Lights (50 = OFF & 250 = ON)
  int redX, redY = 50;       // Alphas of Red Lights (50 = OFF & 250 = ON)
  int yellowX, yellowY = 50; // Alphas of Yellow Lights (50 = OFF & 250 = ON) 
  int time;                  // set to equal millis()
  int lastInterval;          // Used to update time since last light change then used to take away from "time" in order to get amount of time specified
  float interval = 5;        // Interval for Lights in Seconds
  float wait = 1000;         // turn interval from seconds to millis
  char lightX = 'G';         // Switch for Lights on X-Cords
  char lightY = 'R';         // Switch for Lights on Y-Cords
  boolean X, Y, Xy, Yy;      // Booleans for Lights to corespond to draw/make car (Xy & Yy = whether intersection should be crossed if already entered by cars)

  LightAlg (float interval_) { //Constructor and specify light change time wanted
    interval = interval_;
  }

  void run() {
    time = millis(); //Sets time to time since program was executed
    println("Last Interval Times is " + lastInterval/1000); // Prints time since last time lights where changed
    println("X-Light = " + X); //Prints Boolean of X-Light 
    println("Xy-Light = " + Xy); //Prints Boolean of X-Light when it supposed to be yellow in order to creat a flag for whether cars should continue throught intersection
    println("Y-Light = " + Y); //Prints Boolean of Y-Light
    println("Yy-Light = " + Yy);//Prints Boolean of Y-Light when it supposed to be yellow in order to creat a flag for whether cars should continue throught intersection
    if (time - lastInterval < wait * interval) { //  // If the Light has been green for less than wait time by taking millis() - time since last light change < time wanted for light interval
      if (X == true && Xy == true) { //If light is green and intersection is ok to enter
        my_array.draw_cars();
        my_array.make_car();
        my_array.check_collision();
      }
    } 

    if (time - lastInterval >= wait * interval) {  // If the Light hasn't changed for longer then specified interval time

      if ((X == false && Xy == false) && (Y == false && Yy == true)) { //If X-Light is Red and Intersection is not safe to cross && Y-Light is yellow and Intersections is safe to cross
        lightX = 'G'; //X-Light Goes Green
        lightY = 'R'; //Y-Light Goes Red
      } 
      else if ((X == true && Xy == true) && (Y == false && Yy == false)) { //If X-Light is Green and Intersection is safe to cross && Y-Light is Red and Intersections is  not safe to cross
        lightX = 'Y'; //X-Light Goes Yellow
        lightY = 'R'; //Y-Light Goes Red
      } 
      else if ((X == false && Xy == true) && (Y == false && Yy == false)) { // If X-Light is Yellow and Intersection is safe to cross && Y-Light is Red and intersection is not safe to cross
        lightX = 'R'; //X-Light Goes Red
        lightY = 'G'; //Y-Light Goes Green
      }
      else if ((X == false && Xy == false) && (Y == true && Yy == true)) { // If X-Light is Red and Intersection is not safe to cross && Y-Light is Green and intersection is safe to cross
        lightX = 'R'; //X-Light Goes Red
        lightY = 'Y'; //Y-Light Goes Green
      }
      else if ((X == false && Xy == false) && (Y == false && Yy == true)) { // If X-Light is Red and Intersection is not safe to cross && Y-Light is Yellow and Intersection is safe to cross
        lightX = 'G'; //X-Light Goes Green
        lightY = 'R'; //Y-Light Goes Red
      }
      lastInterval = time; // Update last Interval to time of light change so that you can Minus it from time in order to set time back to length of interval desired
    }


    switch(lightX) {        //Switch For X-Cord Lights
    case 'G':              // Green Light
      println("X-Axis = Green Light");
      time = millis(); //Update time when light changes
      greenX = 250; //Alphas for trafficlight Object
      yellowX = 50; //Alphas for trafficlight Object
      redX = 50; //Alphas for trafficlight Object
      X = true; //Light is Green so boolean for cars on Xpos BEFORE intersection is true
      Xy = true;
      break;

    case 'Y':              // Yellow Light
      println("X-Axis = Yellow Light");
      time = millis(); //Update time when light changes
      greenX = 50; //Alphas for trafficlight Object
      yellowX = 250; //Alphas for trafficlight Object
      redX = 50; //Alphas for trafficlight Object
      Xy = true; //Light is Yellow so boolean for cars on Xpos INSIDE/AFTER intersection is true
      X = false; //Light is Yellow so boolean for cars on Xpos BEFORE intersection is false
      break;


    case 'R':             //Red Light
      println("X-Axis = Red Light");
      time = millis(); //Update time when light changes
      greenX = 50; //Alphas for trafficlight Object
      yellowX = 50; //Alphas for trafficlight Object
      redX = 250; //Alphas for trafficlight Object
      Xy = false; //Light is RED so boolean for cars on Xpos INSIDE/AFTER intersection is false
      X = false; //Light is Red so boolean for cars on Xpos BEFORE intersection is false
      break;
    }

    switch(lightY) {       //Switch For Y-Cord Lights
    case 'G':              // Green Light
      println("Y-Axis = Green Light");
      println(time/1000);
      println();
      time = millis(); //Update time when light changes
      greenY = 250; //Alphas for trafficlight Object
      yellowY = 50; //Alphas for trafficlight Object
      redY = 50; //Alphas for trafficlight Object
      Y = true; //Light is GREEN so boolean for cars on Ypos BEFORE intersection is true
      Yy = true; //Light is GREEN so boolean for cars on Ypos INSIDE/AFTER intersection is true
      break;

    case 'Y':              // Yellow Light
      println("Y-Axis = Yellow Light");
      println(time/1000);
      println();
      time = millis(); //Update time when light changes
      greenY = 50; //Alphas for trafficlight Object
      yellowY = 250; //Alphas for trafficlight Object
      redY = 50; //Alphas for trafficlight Object
      Yy = true; //Light is YELLOW so boolean for cars on Ypos INSIDE/AFTER intersection is true
      Y = false; //Light is YELLOW so boolean for cars on Ypos BEFORE intersection is false
      break;


    case 'R':             //Red Light
      println("Y-Axis = Red Light");
      println(time/1000);
      println();
      time = millis(); //Update time when light changes
      greenY = 50; //Alphas for trafficlight Object
      yellowY = 50; //Alphas for trafficlight Object
      redY = 250; //Alphas for trafficlight Object
      Y = false;  //Light is RED so boolean for cars on Ypos BEFORE intersection is false
      Yy = false; //Light is RED so boolean for cars on Ypos INSIDE/AFTER intersection is false
      break;
    }
  }
}