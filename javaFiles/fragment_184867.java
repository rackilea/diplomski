abstract public class Memoize0<V> {
    //the memory
    private V value;
    public V get() {
        if (value == null) {
            value = calc();
        }
        return value;
    }
    /**
     * will implement the calculation that 
     * is to be remembered thanks to this class
     */
    public abstract V calc();
}

abstract public class Memoize1<P, V> {
    //The memory, it maps one calculation parameter to one calculation result
    private Map<P, V> values = new HashMap<P, V>();

    public V get(P p) {
        if (!values.containsKey(p)) {
            values.put(p, calc(p));
        }
        return values.get(p);
    }

    /**
     * Will implement the calculations that are
     * to be remembered thanks to this class
     * (one calculation per distinct parameter)
     */
    public abstract V calc(P p);
 }