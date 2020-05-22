<T> T requireNonNull(T obj) {
    if (obj == null) {
        throw new NullPointerException();
    } else {
        return obj;
    }
}