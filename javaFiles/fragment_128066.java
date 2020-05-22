@SafeVarargs
private static void switchType(StripeObject so, Predicate<Object>... predicates) {
    for(Predicate<Object> predicate : predicates)
        if(predicate.test(so)) return;
}

private static <T> Predicate<Object> caze(Class<T> clazz, Consumer<T> consumer) {
    return obj -> {
        if(clazz.isInstance(obj)) {
            consumer.accept(clazz.cast(obj));
            return true;
        }
        return false;
    };
}