private class IRunnable implements Runnable {
    private I i;

    public IRunnable(I i) {
        this.i = i;
    }

    @Override
    public void run() {
        i.m();
    }
}

Runnable r = new IRunnable(i);