public CompletableFuture<Void> future3() {
    return someService.asyncCall()
        .thenComposeAsync(response -> {
            ....
            return CompletableFuture.allOf(
                future4(),
                future5(),
                future6()
            );
        }
    );
}