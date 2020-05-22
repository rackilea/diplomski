long origThreadID = Thread.currentThread().getId();
Log.d(TAG, "origThreadID (A): " + origThreadID);
final Handler handlerForOriginalThread = new Handler(activity.getMainLooper());

new Thread(new Runnable() 
{
    public void run() 
    {

        handlerForOriginalThread.post(new Runnable() 
        {
            public void run() 
            {
                long origThreadID = Thread.currentThread().getId();
                Log.d(TAG, "origThreadID (B): " + origThreadID);
            }
        });
    }
}).start();