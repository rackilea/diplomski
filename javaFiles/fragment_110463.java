public void run() {
    Log.i("a", "Thread starting.");

    m.play(); // blocks till stopped from some other thread...

    Log.i("b", "Thread stopping.");
    Log.i("c", "Thread shutting down as it was requested to stop.");

    backgroundThread = null;
}