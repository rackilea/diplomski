public CompletionStage<Result> onAuthFailure(final Http.Context context,
                                             final Optional<String> content) {
    return CompletableFuture.supplyAsync(() -> content.map(redirectKey -> {
        final Result result;
        if ("login".equals(redirectKey)) {
            result = [redirect to login action]
        }
        else if ("create-user".equals(redirectKey)) {
            result = [redirect to create user action]
        } else {
            result = [redirect to default authorization failure action]
        }
    }).orElseGet(() -> [redirect to default authorization failure action]), executor);
}