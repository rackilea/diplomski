... decorateSupplier(Retry retry, Supplier<T> supplier) {
        return () -> {
            Retry.Context<T> context = retry.context();
            do try {
               ...
            } catch (RuntimeException runtimeException) {
               ...