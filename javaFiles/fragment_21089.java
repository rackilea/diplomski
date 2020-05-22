static <T> Function1<T, Unit> $(Consumer<T> consumer) {
    return t -> {
        consumer.accept(t);
        return Unit.INSTANCE;
    };
}