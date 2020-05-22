class For {
public static <T> void each (Collection<T> c, Visitor<T> f) {
    for (T v : c) {
        f.visit(v);
    }
} // ()