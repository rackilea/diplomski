private TimerPopTask timerPopTask;

private boolean startTimer() {
    try {
        if (timerPopTask != null) {
            timerPopTask.deactivate();
        }

        timerPopTask = new TimerPopTask();
        _Timer.schedule(timerPopTask, 
                        TIMER_IN_SECONDS, 
                        TimeUnit.SECONDS);
        return true;
    } catch (Exception e) {
        return false;
    }
}