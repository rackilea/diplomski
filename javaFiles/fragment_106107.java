// assume "speedForThisFrame" is a float defined outside this function
float speedForNextFrame = speedForThisFrame
// iterate through however you want
Iterator<Rectangle> iter = array.iterator();
while ( iter.hasNext() ) {
    Rectangle obj = iter.next();
    obj.x += speedForThisFrame * Gdx.graphics.getDeltaTime() ;

    // if it's moved out of bounds, we will change direction NEXT fame
    if (obj.x + obj.width > 800 || obj.x < 0) {
        speedForNextFrame = -speedForThisFrame;
    }
}
// now that all movement has finished, we update the speed
speedForThisFrame = speedForNextFrame