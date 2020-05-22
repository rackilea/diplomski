double startX = -1;
double startY = -1;

while( true ) {

    // ...Your code...

    if( startX > -1 || startY > -1 ) {
       Stage.setTitle("Constellation Simulator");  // Should be outside the while loop
       gc.setFill(Color.YELLOW);  // Should be outside the while loop
       gc.fillRect(x,y,10,10);
       gc.setStroke(Color.RED);  // Should be outside the while loop
       gc.strokeLine(startX,startY,x,y);
    }
}

// Save the current position
startX = x;
startY = y;