private boolean startTimer() {
    // ......
        if (_TimerFuture != null) {
            _TimerFuture.cancel(false);
        }

        _TimerFuture = _Timer.schedule(new TimerPopTask(), 
                                       TIMER_IN_SECONDS, 
                                       TimeUnit.SECONDS);
    // ......
}