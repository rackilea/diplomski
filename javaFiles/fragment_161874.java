static <T> Function<T, T> identity1() {
    return t -> t;
}

static <T> T identity2(T in) {
    return in;
}