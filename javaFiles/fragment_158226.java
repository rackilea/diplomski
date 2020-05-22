private void waitForCompletion(List<Future<HttpResponse>> futureList) {
    for(Future<HttpReponse> future:futureList) {
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            LOG.error("Something went wrong: ", e);
        }
    }
}