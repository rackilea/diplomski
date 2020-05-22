int threadNum = requestItems.size();
ExecutorService exs = Executors.newFixedThreadPool(threadNum);

for (int i = 0; i < threadNum; i++) {
    ResponseInterface response = new CMSGOResponse();
    exs.execute(new RequestTask(requestItems.poll(), this, response));
}
exs.shutdown();
while (! exs.isTerminated()) {
    try {
        exs.awaitTermination(1L, TimeUnit.DAYS);
    }
    catch (InterruptedException e) {
        // you may or may not care here, but if you truly want to
        // wait for the pool to shutdown, just ignore the exception
        // otherwise you'll have to deal with the exception and
        // make a decision to drop out of the loop or something else.
    }
}