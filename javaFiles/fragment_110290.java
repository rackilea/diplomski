AsyncHttpClient client = new AsyncHttpClient();
client.post("https://url.com/getdata?username=abcd123&password=123456", new AsyncHttpResponseHandler() {
    @Override
    public void onSuccess(String response) {
        // success
    }

    @Override
    public void onFailure(Throwable error, String content) {
        // something went wrong
    }
});