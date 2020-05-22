public class TaskList implements TimedTaskListener {

    private List<TimedTask> timers = new ArrayList<>(25);
    private boolean running = false;
    private TimedTask current;

    public void add(TimedTask timer) {
        timer.addTimedTaskListener(this);
        timers.add(timer);
    }

    public void remove(TimedTask timer) {
        timer.removeTimedTaskListener(this);
        timers.remove(timer);
    }

    public boolean isRunning() {
        return running;
    }

    public void start() {
        if (current != null) {
            current.start();
            running = true;
        } else {
            startNext();
        }
    }

    public void stop() {
        if (current != null) {
            current.stop();
        }
        running = false;
    }

    protected void startNext() {
        if (!timers.isEmpty()) {
            current = timers.remove(0);
            current.start();
            running = true;
        } else {
            running = false;
        }
    }

    @Override
    public void taskStateChanged(TimedTaskEvent evt) {
        switch (evt.getState()) {
            case COMPLETED:
                TimedTask timer = (TimedTask) evt.getSource();
                remove(timer);
                startNext();
                break;
        }
    }
}