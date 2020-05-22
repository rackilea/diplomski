static CompletionStage<String> register(String username) {
    throw new UnsupportedOperationException();
}

static void sendConfirmationEmail(String username) {
    throw new UnsupportedOperationException();
}

public static void main(String[] args) throws InterruptedException {

    register("user").thenAcceptAsync(username -> sendConfirmationEmail(username));

}