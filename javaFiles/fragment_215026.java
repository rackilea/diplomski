builder.setHttpRequestInitializer(new HttpRequestInitializer(){
    @Override
    public void initialize(HttpRequest request) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("JSESSIONID", prefs.getCookie());
        request.setHeaders(httpHeaders);
  }
});

builder.setRootUrl("https://android-app-backend.appspot.com/_ah/api/");
UserEndpoint service = builder.build();
response = service.getRoles().execute();