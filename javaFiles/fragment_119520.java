private static class Tuple<T, S> {

    final T first;
    final S second;

    Tuple(T k, S v) {
        this.first = k;
        this.second = v;
    }
}