@Override
public boolean onTouchEvent(MotionEvent event) 
{
    // If the user touches the space occupied by object1
    if(event.getAction() == MotionEvent.ACTION_DOWN 
            && event.getX() <= object1.xPosition + object1.width 
            && event.getX() >= object1.xPosition
            && event.getY() >= object1.yPosition 
            && event.getY() < object1.yPosition + object1.height)
    {
            // The click was in the bounds of object1's current location
        object1.doSomething();
    }
    // ......
}