@SuppressWarnings("serial")
public class SpinnerModel2 extends AbstractSpinnerModel {
    private long value;
    private long min;
    private long max;
    private long increment;

    public SpinnerModel2(long value, long min, long max, long increment) {
        super();
        this.value = value;
        this.min = min;
        this.max = max;
        this.increment = increment;
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
    public void setValue(Object value) {
        this.value = (long) value;
        fireStateChanged();
    }

}