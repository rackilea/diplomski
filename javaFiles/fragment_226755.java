public interface TimedTask {
    public void addTimedTaskListener(TimedTaskListener listener);
    public void removeTimedTaskListener(TimedTaskListener listener);

    public void addTimedTaskTickListener(TimedTaskTickListener listener);
    public void removeTimedTaskTickListener(TimedTaskTickListener listener);

    public void start();
    public void stop();
    public void reset();
    public boolean isRunning();

    public Duration getRunDuration();
    public Duration getTotalDuration();
}

public class TimedTaskEvent extends EventObject {

    public enum State {
        RUNNING, PAUSED, COMPLETED
    }

    private State state;

    public TimedTaskEvent(Object source, State state) {
        super(source);
        this.state = state;
    }

    public State getState() {
        return state;
    }

}

public interface TimedTaskListener extends EventListener {
    public void taskStateChanged(TimedTaskEvent evt);
}

public interface TimedTaskTickListener extends EventListener {
    public void timedTaskTicked(TimedTaskEvent evt);
}