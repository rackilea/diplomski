if(micks_thread_thing != null) 
{
synchronized (micks_thread_thing.getSurfaceHolder()) // this is the line causing the nullpointerexception
  {
    if (event.getAction() == MotionEvent.ACTION_DOWN) 
    {
      do_down(event.getX(),event.getY());
    }
    if (event.getAction() == MotionEvent.ACTION_MOVE) 
    {
      do_move(event.getX(),event.getY());
    }

    if (event.getAction() == MotionEvent.ACTION_UP) 
    {
      do_up(event.getX(),event.getY());
    }
  }
}