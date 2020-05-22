static <T> Consumer<T> throwingConsumerWrapper(
  ThrowingConsumer<T, Exception> throwingConsumer) {

    return i -> {
        try {
            throwingConsumer.accept(i);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    };
}