Point scoreStartPos = new Point(52, 40);
int scoreBallSize = 40;
Point scorePos = new Point(scoreStartPos );

for (int i = 0; i < score; i++) { 
   drawCircle(scorePos, scoreBallSize); // a little helper method makes your code easier to read

    // increment the positions, and wrap to next col if over screen width
    scorePos.translate( +scoreBallSize, 0);


   if( scorePos.getX() > screenWidth) { // next score ball position is beyond the screen
       scorePos.setLocation(scoreStartPoint.getX(),
                            scorePos.getY() + scoreBallSize);
   }
}