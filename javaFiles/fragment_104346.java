...
private static final int STEPS = 40;
private static final long INTERVAL = 500;//msec
private static final long STEP_INTERVAL = INTERVAL / STEPS;
...
private int stepX, stepY;
...
public void computeMovement() {
 stepX = (endX - startX) / STEPS;
 stepY = (endY - startY) / STEPS;
}
...
public void run() {
 int currX = startX;
 int currY = startY;
 computeMovement();
 for( int i = 0; i < STEPS; i++ ) {
   currX += stepX;
   currY += stepY;
   //move image to (currX, currY)
   TimeUnit.MILISECONDS.sleep( STEP_INTERVAL );
 }
}