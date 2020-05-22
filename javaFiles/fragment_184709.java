public abstract class Buff<V> {
    public V value;
}
public interface Buffable<V extends Buff<?>> {
    public void buff(V buff);
}
// instead of primitive types, you should use their wrappers: double-->Double
public class DoubleBuff extends Buff<Double> {
    public double value;
}
public class DoubleBuffable implements Buffable<DoubleBuff> {
    public void buff(DoubleBuff buff) {
        //implementation
    }
}