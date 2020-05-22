public static <T, U> BiFunction<? super T, Throwable, ? extends U>
        unwrappingCompletionException(BiFunction<? super T, Throwable, ? extends U> fn) {
    return (t, u) -> {
        if (u instanceof CompletionException) {
            return fn.apply(t, u.getCause());
        }
        return fn.apply(t, u);
    };
}