ListenableFuture<SendResult<String, String>> future = template.send("foo", "bar");
try {
    SendResult<String, String> sendResult = future.get(10, TimeUnit.SECONDS);
}
catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    Thread.currentThread.interrupt();
}
catch (ExecutionException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
catch (TimeoutException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}