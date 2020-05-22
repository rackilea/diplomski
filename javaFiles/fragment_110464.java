public void run() {
    Log.i("a", "Thread starting.");
    while (!backgroundThread.isInterrupted()) {
        m.play();
        if(!backgroundThread.isInterrupted())
            Log.i("b", "Stopped by exception, restarting....");
    }

    Log.i("c", "Thread stopping.");
    Log.i("d", "Thread shutting down as it was requested to stop.");

    backgroundThread = null;
}