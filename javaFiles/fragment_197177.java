public void timedMoveIV(final int time_ms)
{
    Handler handler = new Handler(); 
    handler.postDelayed(new Runnable() { 
        public void run() 
        { 
            if(new_x > img.getX())
                img.setX(img.getX() + 1);
            else
                img.setX(img.getX() - 1); 

            // if not in position, call again
            if((int)img.getX() != new_x)
                timedMoveIV(time_ms); 
        } 
    }, time_ms);
}