public static class Worker implements Runnable {

    public enum State {
        RUNNING,
        PAUSED,
        NOT_STARTED,
        STOPPPED,
        COMPLETED;
    }

    private volatile State state = State.NOT_STARTED;