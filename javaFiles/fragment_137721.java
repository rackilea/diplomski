public class SpinnerModel3 implements SpinnerModel {
    private long value;
    private long min;
    private long max;
    private long increment;
    // using a set to avoid allowing addition of duplicate listeners
    private Set<ChangeListener> listenerSet = new HashSet<>();

    public SpinnerModel3(long value, long min, long max, long increment) {
        super();
        this.value = value;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    @Override
    public void addChangeListener(ChangeListener l) {
        listenerSet.add(l);
    }

    @Override
    public Object getNextValue() {
        long nextValue = value + increment;
        nextValue = Math.min(nextValue, max);
        return nextValue;
    }

    @Override
    public Object getPreviousValue() {
        long prevValue = value - increment;
        prevValue = Math.max(prevValue, min);
        return prevValue;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
        listenerSet.remove(l);
    }

    @Override
    public void setValue(Object value) {
        this.value = (long) value;
        fireStateChanged();
    }   

    protected void fireStateChanged() {
        // create a ChangeEvent object
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener l : listenerSet) {
            l.stateChanged(e);  // notify all listeners
        }
    }
}