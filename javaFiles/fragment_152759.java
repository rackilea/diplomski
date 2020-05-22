class Frog {
    private long delay;

    public Frog(long delay) {
        this.delay = delay;
    }

    public void run() {
        Thread.sleep(delay);
    }
}