private boolean isUIThread(){
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
// Setup handler for uncaught exceptions.
    Thread.setDefaultUncaughtExceptionHandler (new Thread.UncaughtExceptionHandler()
    {
        @Override
        public void uncaughtException (Thread thread, Throwable e)
        {
            handleUncaughtException (thread, e);
        }
    });

    public void handleUncaughtException(Thread thread, Throwable e) {
        e.printStackTrace(); // not all Android versions will print the stack trace automatically

        if (isUIThread()) {
            // exception occurred from UI thread
            invokeSomeActivity();

        } else {  //handle non UI thread throw uncaught exception

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    invokeSomeActivity();
                }
            });
        }
    }