public <T,U> U mapWithFallback(T obj, Function<T,U> function, U fallback) {
    if(obj == null) {
        return fallback;
    } else {
        return function.apply(obj);
    }
}