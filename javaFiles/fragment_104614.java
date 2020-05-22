try {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(urls[0])
        .build();
    Response responses = null;

    try {
        responses = client.newCall(request).execute();
    } catch (IOException e) {
        e.printStackTrace();
    }
    String jsonData = responses.body().string();
    JSONObject Jobject = new JSONObject(jsonData);
    JSONArray Jarray = Jobject.getJSONArray("employees");

    for (int i = 0; i < Jarray.length(); i++) {
        JSONObject object     = Jarray.getJSONObject(i);
    }
}