int accel = 1;
boolean accelerating = false;
public void keyPressed(KeyEvent e)
{
   ...
   accelerating = true;
   new Thread() //anonymous inner class 
   { 
     public void run()
     {
       while (accelerating) { x += vel; vel += 1; }
       //no longer accelerating
       x = 0; //or decelerate gracefully with a similar loop as accel.
     }
  }.run();
}
public void keyUp(KeyEvent e) //or however you get a key release event
{
   accelerating = false;
}