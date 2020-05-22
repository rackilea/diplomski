public MainGamePanel(Context context)
{
    ...

    //Also required for touch input.
    setFocusable(true);

    //start thread
    thread.setRunning(true);
    thread.start();
}

@Override
public void surfaceChanged(SurfaceHolder holder, int format, int width,
        int height) {
}

@Override
public void surfaceCreated(SurfaceHolder holder) {
    //continue the thread
    synchronized (thread) {
        thread.pleaseWait = false;
        thread.notifyAll();
    }
}

@Override
public void surfaceDestroyed(SurfaceHolder holder) {
    //pause the thread
    synchronized (thread) {
        thread.pleaseWait = true;
    }
}