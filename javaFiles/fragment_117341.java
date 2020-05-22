public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
OkHttpClient client = new OkHttpClient();
void post(String url, String json) throws IOException {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build();
    okhttp3.Call call = client.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure( @NonNull okhttp3.Call call,@NonNull  IOException e) {
            MyActivity.this.runOnUiThread(new Runnable() {
        @Override
        public void run() {
           //Handle UI here                        
        // Toast anything you like here//                
        }
    });
        }

        @Override
        public void onResponse(@NonNull okhttp3.Call call,@NonNull  Response response) throws IOException {
              MyActivity.this.runOnUiThread(new Runnable() {
        @Override
        public void run() {
           //Handle UI here                        
          //happy on Response Toast here                
        }
    });
        }

        }
    });
}