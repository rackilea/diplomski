public void stop(String timerName) {
    for(Object obj : timerService.getTimers()) {
        Timer t = (Timer)obj;
        if (t.getInfo().equals(timerName)) {
        t.cancel();
        }
    }
}