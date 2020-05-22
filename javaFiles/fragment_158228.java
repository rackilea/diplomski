private void waitForCompletion(List<Future<HttpResponse>> futureList)
                                                   throws Exception {
    for(Future<HttpReponse> future:futureList) {
         future.get();
    }
}