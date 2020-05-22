final int threadNum = Runtime.getRuntime().availableProcessors();
final ExecutorService exs = Executors.newFixedThreadPool(threadNum);

while (true) {
    final RequestItem requestItem = requestItems.poll();
    if (requestItem == null) {
        break;
    }
    final ResponseInterface response = new CMSGOResponse(); 
    exs.execute(new RequestTask(requestItem , this, response));
}
exs.shutdown();