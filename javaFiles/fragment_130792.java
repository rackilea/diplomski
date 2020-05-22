mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
{
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY)
    {
        enter(words, linearLayout, llp, view);
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        super.onLongPress(e);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return super.onSingleTapConfirmed(e);
    }

    private boolean permissibleYVelocity(float velocityY)
    {
        if ((velocityY < -200) || (velocityY > 200))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
});