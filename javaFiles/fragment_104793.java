import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.Double.*;

class AtomicDouble extends Number {

    private AtomicLong bits;

    public AtomicDouble() {
        this(0.0);
    }

    public AtomicDouble(double initialValue) {
        bits = new AtomicInteger(doubleToLongBits(initialValue));
    }

    public final boolean compareAndSet(double expect, double update) {
        return bits.compareAndSet(doubleToLongBits(expect),
                                  doubleToLongBits(update));
    }

    public final void set(double newValue) {
        bits.set(doubleToLongBits(newValue));
    }

    public final double get() {
        return longBitsToDouble(bits.get());
    }

    public double doubleValue() {
        return get();
    }

    public final float getAndSet(double newValue) {
        return longBitsToDouble(bits.getAndSet(doubleToLongBits(newValue)));
    }

    public final boolean weakCompareAndSet(double expect, double update) {
        return bits.weakCompareAndSet(doubleToLongBits(expect),
                                      doubleToLongBits(update));
    }

    public float floatValue() { return (float) doubleValue(); }
    public int intValue()       { return (int) get(); }
    public long longValue()     { return (long) get(); }

}