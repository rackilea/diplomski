public void accept(Object obj) {
    accept(obj.getClass(), obj);
}
private <T> void accept(Class<T> key, Object obj) {
    Consumer<? super T> c = get(key);
    if (c != null)
        c.accept(key.cast(obj));
}