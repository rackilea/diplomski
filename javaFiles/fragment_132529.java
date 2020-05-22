ScheduledExecutorService daemon = Executors.newScheduledThreadPool(1);
daemon.scheduleWithFixedDelay(new MyRunnable(myMapToCheck), 
                              10, 10, TimeUnit.MINUTE);
//...
private static class MyRunnable implements Runnable {
    private final Map<K, V> lastState;
    private final Map<K, V> map;

    public MyRunnable(Map<K, V> map) {
        this.map = map;
        this.lastState = new HashMap<>(map);
    }

    @Override
    public void run() {
        // copy to avoid changes before updating lastState
        Map<K, V> currentState = new HashMap<>(map);
        if(currentState.equals(lastState)) {
            System.our.println("No change");
        } else {
            System.our.println("Change!");
        }
        lastState.clear();
        lastState.putAll(currentState);
    }
}