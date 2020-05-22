public class DefaultTimedTask implements TimedTask {

    private EventListenerList listenerList = new EventListenerList();

    private Timer timer;

    // How long the timer has been continuosuly running     
    private Duration totalDuration;
    // The time of the last tick
    private LocalDateTime tickTime;

    // How long the timer should run for
    private Duration runDuration;

    public DefaultTimedTask(Duration duration, int tickInterval) {
        runDuration = duration;
        totalDuration = Duration.ZERO;
        timer = new Timer(tickInterval, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tickTime == null) {
                        tickTime = LocalDateTime.now();
                    }
                    LocalDateTime now = LocalDateTime.now();
                    Duration tickDuration = Duration.between(tickTime, now);
                    totalDuration = totalDuration.plus(tickDuration);

                    fireTaskTimerTicked();

                    if (totalDuration.compareTo(runDuration) >= 0) {
                        timer.stop();
                        fireTaskTimerStartedChanged(TimedTaskEvent.State.COMPLETED);
                    }
                }
            });
    }

    @Override
    public void reset() {
        timer.stop();
        tickTime = null;
        totalDuration = Duration.ZERO;
    }

    public void setPaused(boolean paused) {
        if (paused && timer.isRunning()) {
            timer.stop();
            fireTaskTimerStartedChanged(TimedTaskEvent.State.PAUSED);
        } else if (!paused && !timer.isRunning()) {
            tickTime = null;
            timer.start();
            fireTaskTimerStartedChanged(TimedTaskEvent.State.RUNNING);
        }
    }

    protected void fireTaskTimerTicked() {
        TimedTaskTickListener[] listeners = listenerList.getListeners(TimedTaskTickListener.class);
        if (listeners.length > 0) {
            TimedTaskEvent evt = new TimedTaskEvent(this, TimedTaskEvent.State.RUNNING);
            for (TimedTaskTickListener listener : listeners) {
                listener.timedTaskTicked(evt);
            }
        }
    }

    protected void fireTaskTimerStartedChanged(TimedTaskEvent.State state) {
        TimedTaskListener[] listeners = listenerList.getListeners(TimedTaskListener.class);
        if (listeners.length > 0) {
            TimedTaskEvent evt = new TimedTaskEvent(this, state);
            for (TimedTaskListener listener : listeners) {
                listener.taskStateChanged(evt);
            }
        }
    }

    public boolean isPaused() {
        return !timer.isRunning();
    }

    @Override
    public void addTimedTaskListener(TimedTaskListener listener) {
        listenerList.add(TimedTaskListener.class, listener);
    }

    @Override
    public void removeTimedTaskListener(TimedTaskListener listener) {
        listenerList.remove(TimedTaskListener.class, listener);
    }

    @Override
    public void addTimedTaskTickListener(TimedTaskTickListener listener) {
        listenerList.add(TimedTaskTickListener.class, listener);
    }

    @Override
    public void removeTimedTaskTickListener(TimedTaskTickListener listener) {
        listenerList.remove(TimedTaskTickListener.class, listener);
    }

    @Override
    public void start() {
        setPaused(false);
    }

    @Override
    public void stop() {
        setPaused(true);
    }

    @Override
    public boolean isRunning() {
        return timer.isRunning();
    }

    @Override
    public Duration getTotalDuration() {
        return totalDuration;
    }

    @Override
    public Duration getRunDuration() {
        return runDuration;
    }

}