public TestAsyncTask(GoogleAccountCredential credential, MainActivity activity) {
  HttpTransport transport = AndroidHttp.newCompatibleTransport();
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    mService = new com.google.api.services.tasks.Tasks.Builder(
            transport, jsonFactory, credential)
            .setApplicationName("Google Tasks API Android Quickstart")
            .build();
  this.activity = activity;
}