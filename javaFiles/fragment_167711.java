Object requireNonNull(Object obj) {
    if (obj == null) {
        throw new NullPointerException();
    } else {
        return obj;
    }
}