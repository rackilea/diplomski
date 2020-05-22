// is the ball above the box?
if(Math.abs(ball.ballCenterY-boundingBox.top) < ball.radius)
{
    if(ball.ballCentreX >= boundingBox.left)
    {
         if(ball.ballCentreY <= boundingBox.right)
         {
             // ball hit the top edge
         }
         else
         {
             // ball hit the top right corner
         }
    }
    else
    {
        // hit top left corner
    }
}