public void fetchJsonData(Activity activity,String url){
    final WeakReference<Activity> activityWeakReference = new WeakReference<Activity>(activity);
    OkHttpClient client = new OkHttpClient();
    Request req = new Request.Builder()
            .url(url)
            .build();

    Call call = client.newCall(req);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {
            Activity activity = activityWeakReference.get();
            if (activity != null) {
                activity.failed();
            }
        }

        @Override
        public void onResponse(Response response) throws IOException {
            jSonData = response.body().string();
            Activity activity = activityWeakReference.get();
            if (activity != null) {
                activity.success(jSonData);
            }
        }
    });
}