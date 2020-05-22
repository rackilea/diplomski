package reports.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Thread Local variable that holds a {@code java.util.Map}.
 */
class ThreadLocalMap<K, V> extends ThreadLocal<Map<K, V>> {

    /**
     * Class Constructor.
     */
    public ThreadLocalMap() {
        super();
    }


    /* (non-Javadoc)
     * @see java.lang.ThreadLocal#initialValue()
     */
    @Override
    protected Map<K, V> initialValue() {
        return new HashMap<>();
    }
}