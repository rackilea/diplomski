RequestParams params = new RequestParams();
params.put("username", "abcd123");
params.put("password", "123456");

AsyncHttpClient client = new AsyncHttpClient();
client.post("https://url.com/getdata", params, new AsyncHttpResponseHandler() {
    @Override
    public void onSuccess(String response) {
        // success
    }

    @Override
    public void onFailure(Throwable error, String content) {
        // something went wrong
    }
});