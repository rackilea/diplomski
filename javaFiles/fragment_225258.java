.handle((GenericHandler<?>) (p, h) -> {
                    throw new RuntimeException("intentional");
                }, e -> e.advice(retryAdvice()))

    @Bean
    public RequestHandlerRetryAdvice retryAdvice() {
        RequestHandlerRetryAdvice requestHandlerRetryAdvice = new RequestHandlerRetryAdvice();
        requestHandlerRetryAdvice.setRecoveryCallback(new ErrorMessageSendingRecoverer(recoveryChannel()));
        return requestHandlerRetryAdvice;
    }