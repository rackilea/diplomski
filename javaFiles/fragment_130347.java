private final OkHttpClient client = new OkHttpClient();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_events_create);

    ActionBar actionBar = this.getSupportActionBar();
    actionBar.setTitle("Test");
    actionBar.setDisplayHomeAsUpEnabled(true);

    makePost();
}

private void makePost(){
    RequestBody requestBody = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("email", "your-email@email.com")
        .addFormDataPart("name", "your-name")
        .build();

    request = new Request.Builder()
        .url("http://myip/task_manager/v1/register")
        .post(requestBody)
        .build();

    try (Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

      Headers responseHeaders = response.headers();
      for (int i = 0; i < responseHeaders.size(); i++) {
        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
      }

      System.out.println(response.body().string());
   }
}