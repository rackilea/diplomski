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
                Log.e("TAG", "Failed sending message!");
//using a toast means updating the UI thread from back thread you have to call Content.runOnUiThread(new Runnable) to sync with the UI thread.
                //Toast.makeText(MainActivity.this,"Failed sending message",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NonNull okhttp3.Call call,@NonNull  Response response) throws IOException {
                Log.d("TAG", "Message sent successfully!");
                Log.d("TAG", response.body().string());
                //Toast.makeText(MainActivity.this,"Message sent successfully!",Toast.LENGTH_LONG).show();

            }
        });
    }