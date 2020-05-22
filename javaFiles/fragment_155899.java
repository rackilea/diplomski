private static ExecutorService executor 


private static void moveMessagesToFolders(List<Message> listMessages, Store store, Set<String> setSender) throws MessagingException {
    executor = Executors.newFixedThreadPool(4);

    HashMap<String, List<Message>> mapMessages = separeteMessagesBySender(listMessages, setSender);

    for (Map.Entry<String, List<Message>> mapMessage : mapMessages.entrySet()) {
        Message[] messageArray = mapMessage.getValue().toArray(new Message[mapMessage.getValue().size()]);
        moveMessagesThread(messageArray, mapMessage, store);
    }

    executor.shutdown();
}

private static void moveMessagesThread(Message[] messageArray, Map.Entry<String, List<Message>> mapMessage, Store store) {
    List<Future<Boolean>> futures = createMovimentSetThread(messageArray, mapMessage, store);

    for (Future<Boolean> future : futures) {
        try {
            Boolean success = future.get(); // Will wait to accomplished all submited Callables
            if(!success) { // Check if all submited callables end succesulfy 
                throw new RuntimeException("Something goes wrong while moving messages");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

private static List<Future<Boolean>> createMovimentSetThread(Message[] messageArray, Map.Entry<String, List<Message>> mapMessage, Store store) {
    int [] threadIndexs = MathUtil.generateIndex(messageArray);
    List<Future<Boolean>> futures = new ArrayList<>();

    for (int i = 0; i < threadIndexs.length; i++) {
        Future<Boolean> submit = executor.submit(new ThreadMoveMessages(messageArray, mapMessage, store, threadIndexs[i]));
        futures.add(submit);
    }

    return futures;
}