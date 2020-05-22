Handler target;     // a handler that enqueued the message
    long when;          // the time at which the message is to be processed 

    [RUNNABLE] Runnable callback;   =
    [SWITCHED] int what, int arg1, int arg2, Bundle data...

    bool isAsynchronous; // I will talk about it in the end