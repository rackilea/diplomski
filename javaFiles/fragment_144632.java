youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {          
  @Override
  public void initialize(HttpRequest request) throws IOException {
    credential.initialize(request);
    request.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(new ExponentialBackOff()));
  }
});