long maxWorkingTimePerFrame = 1000 / FRAMES_PER_SECOND;  //this is optional
lastStartTime = System.currentTimeMillis();
while(true)
{
    long elapsedTime = System.currentTimeMillis() - lastStartTime;
    lastStartTime = System.currentTimeMillis();

    Tick(elapsedTime);

    //enforcing a maximum framerate here is optional...you don't need to sleep the thread
    long processingTimeForCurrentFrame = System.currentTimeMillis() - lastStartTime;
    if(processingTimeForCurrentFrame  < maxWorkingTimePerFrame)
    {
        try
        {
            Thread.sleep(maxWorkingTimePerFrame - processingTimeForCurrentFrame);
        }
        catch(Exception e)
        {
            System.err.println("TSEngine :: run :: " + e);
        }
    }
}