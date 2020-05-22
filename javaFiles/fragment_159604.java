try {
    Set<Conversation> conversations = fetchConversations(data, id).get();
} catch (InterruptedException e) {
    // handle the InterruptedException
    e.printStackTrace();
} catch (ExecutionException e) {
    // handle the ExecutionException
    // e.getCause() is your CustomException or any other exception thrown from the chain
}