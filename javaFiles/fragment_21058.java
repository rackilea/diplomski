public void move(Ball ball, Point mouse) {
     Point p = ball.getLocation();
     Point speed = ball.getSpeed();
     Dimension size = ball.getSize();

     if (mouse != null) {
         System.out.println(mouse.x);  // here 
     }

     int vx = speed.x;
     int vy = speed.y;
     // ...