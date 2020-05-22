boolean mouseDown = false;

public boolean onTouchEvent(MotionEvent event) 
{
    switch(event.getAction() & MotionEvent.ACTION_MASK)
    {
    case MotionEvent.ACTION_UP:
    {
        if(mouseDown)
        {
            ToggleSelection();
            invalidate();
            mouseDown = false;
        }
        break;
    }
    case MotionEvent.ACTION_OUTSIDE:
    case MotionEvent.ACTION_CANCEL:
    case MotionEvent.ACTION_POINTER_DOWN:
    case MotionEvent.ACTION_POINTER_UP:
    {
        mouseDown = false;
        break;
    }
    case MotionEvent.ACTION_DOWN:
    {
        mouseDown = true;
        return true;
    }
    }
    return false;
}