@Override
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) 
{
    enter(words, linearLayout, llp, view);
    return true;
}