class MyThread extends Thread {

    private volatile boolean running = true; // Run unless told to pause

    ...

    @Override
    public void run()
    {
        for(int i=0 ; ; i++)
        {

            // This is a crude implementation of pausing the thread
            while (!running)
                // Work

            area.setText(i+"");
    }

    public void pauseThread() throws InterruptedException
    {
        running = false;
    }

    public void resumeThread()
    {
        running = true;
    }

}