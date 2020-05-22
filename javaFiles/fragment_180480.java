JsonFactory jsonFactory = new JacksonFactory();
HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
HttpRequestInitializer httpRequestInitializer = new HttpRequestInitializer() {
   @Override
   public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setReadTimeout(60000); // 60 seconds
    }
};

BatchRequest batch = p.batch(httpRequestInitializer);
Pagespeedonline p = new Pagespeedonline.Builder(transport, jsonFactory, httpRequestInitializer).setApplicationName(APP_NAME).build();

//Loop to add as many as you want
for (int i = 0; i < urls.size(); ++i) {
    Pagespeedonline.Pagespeedapi.Runpagespeed check = p.pagespeedapi().runpagespeed(urls.get(i)).setKey(GOOGLE_KEY).setStrategy(DEVICE);
    check.queue(batch, callback);
}

batch.execute();