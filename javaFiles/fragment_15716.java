private Button rightButton; // You will assign this in onCreate() method
private Handler mHandler = new Handler();
private Runnable mRunnable = new Runnable() {
    @Override
    public void run() {
        if(rightButton.isPressed())
        {
            // If press state is pressed, move your item and recall the runnable in 100 milliseconds.
            mover.updateCoordinates(1,  0);
            mHandler.postDelayed(mRunnable, 100);
        }
    }
};