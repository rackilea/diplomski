class LockedSensors implements Sensors {
    private static final class State {
        final long time;
        final double[] data;
        State(long t, double[] in) {
            time = t;
            data = in.clone();
        }
    }
    final AtomicReference<State> current = new AtomicReference<>();
    LockedSensors() {}

    // store data and timestamp
    // if and only if data stored previously is older (lower timestamp)
    public void update(long timestamp, double[] data) {
        State newState = null;
        for(;;) {
            State old = current.get();
            if(old != null && old.time > timestamp) return;
            if(newState == null) newState = new State(timestamp, data);
            if(current.compareAndSet(old, newState)) return;
        }
    }

    // pre: val != null
    // pre: val.length matches length of data written via update
    // if no data has been written previously, return 0
    // otherwise return current timestamp and fill current data to array passed as val
    public long get(double[] val) {
        State actual = current.get();
        if(actual == null) return 0;
        if(actual.data.length != val.length)
            throw new IllegalArgumentException();
        System.arraycopy(actual.data, 0, val, 0, actual.data.length);
        return actual.time;
    }
}