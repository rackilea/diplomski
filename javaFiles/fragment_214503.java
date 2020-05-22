package java.util;

import java.util.Collections.SynchronizedSortedMap;

public class NewCollections {

    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> m) {
        return new SynchronizedNavigableMap<K, V>(m);
    }

    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private final NavigableMap<K, V> sm;

        SynchronizedNavigableMap(NavigableMap<K, V> m) {
            super(m);
            sm = m;
        }

        SynchronizedNavigableMap(NavigableMap<K, V> m, Object mutex) {
            super(m, mutex);
            sm = m;
        }

    }
}