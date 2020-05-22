// flag to tell if the rotation should continue
private boolean keepRotating = false;
// instance variable to keep the current rotation degrees
private int degrees = 0;
// rotation interval in milliseconds
private static final int INTERVAL = 100;

@Override
public boolean onTouchEvent(MotionEvent event)
{
    switch (event.getAction())
    {
        case MotionEvent.ACTION_DOWN:
            startRotating();
            break;
        case MotionEvent.ACTION_UP:
            stopRotating();
            break;
    }

    return super.onTouchEvent(event);
}

public void startRotating()
{
    if (!keepRotating)
    {
        keepRotating = true;

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (keepRotating)
                {
                    degrees = (degrees + 10) % 360;
                    make(degrees);

                    handler.postDelayed(this, INTERVAL);
                }
            }
        }, INTERVAL);
    }
}

public void stopRotating()
{
    keepRotating = false;
}

public void make(int degrees)
{
    Log.i(this.getClass().toString(), "Rotation : " + degrees);

    // Your rotation logic here based on the degrees parameter
    // ...
}