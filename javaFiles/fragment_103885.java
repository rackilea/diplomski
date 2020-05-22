Robot r;
long sleepDuration = 60001;
synchronized (r) {
    try {
        Thread.sleep(sleepDuration);
    } catch(InterruptedException ite) {
        ite.printStackTrace();
    }
}