public boolean onTouch(View v, MotionEvent event)
{
    synchronized(this)
    {
        //all the common code handling the actual handling, with switches and such
        touchTables.add(pointerId, touchTable); //obviously the pointerId is defined earlier
        Log.d(Tag, "Values updated");
        if (helper != null)
            helper.onTouchUpdate(pointerId); //the exception is here
        Log.d(Tag, "Update called");
    }
    return true;
}