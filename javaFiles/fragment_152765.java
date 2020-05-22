public <T> Consumer<? super T> findApplicable(Class<T> key) {
    Consumer<? super T> c = get(key);
    if (c == null) {
        for (Map.Entry<Class<?>, Consumer<?>> e : map.entrySet()) {
            if (e.getKey().isAssignableFrom(key)) {
                @SuppressWarnings("unchecked")
                Consumer<? super T> value =
                    (Consumer<? super T>) e.getValue();
                c = value;
                break;
            }
        }
    }
    return c;
}