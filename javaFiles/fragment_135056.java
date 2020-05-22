static <E, T> void done(E e, Map.Entry<String, T> m) {
     // do something
}

// using immutable entry
static <E, T> void done(E e, String k, T v) {
    done(e, Map.entry(k, v));
}

// using mutable entry 
static <E, T> void done(E e, String k, T v) {
    done(e, new AbstractMap.SimpleEntry<>(k, v));
}