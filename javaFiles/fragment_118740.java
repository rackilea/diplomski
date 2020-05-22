int scoreStartX = 52;
int scoreStartY = 40;
int scoreBallSize = 40;
// scorePosX/Y means the position the score-ball should be drawn
scorePosX = scoreStartX;  // scoreStartX/Y = starting position of score balls 
scorePosY = scoreStartY;

for (int i = 0; i < score; i++) { 
    ellipse(scorePosX , scorePosY , scoreBallSize , scoreBallSize);

    // increment the positions, and wrap to next col if over screen width
    scorePosX += scoreBallSize ;


   if( scorePosX  > screenWidth) { // next score ball position is beyond the screen
       scorePosX = scoreStartX;
       scorePosY += scoreBallSize;
   }
}