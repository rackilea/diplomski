public CompletableFuture<Set<Conversation>> fetchConversations(List<Information> data, String sessionId) {
    return myservice
            .get(prepareRequest(data, sessionId))
            .thenApply(HtmlResponse::getDocument)
            .thenApply(value -> {
                if (checkSomeCondition(value)) 
                    throw new CompletionException(new CustomException("Reason"));
                return value;
            })
            .thenApply(this::extractConversationsFromDocument)
            .exceptionally(e -> {
                // the .thenApply(this::extractConversationsFromDocument) step 
                // was not executed
                return Collections.emptySet(); //or null
            });
}