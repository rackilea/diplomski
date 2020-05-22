String url = "http://www.yourdomain/loginstudent.php";
RequestParams params = new RequestParams();
    params.put("username", YOURTEXT);
    params.put("password", lng);
    AsyncHttpClient client=new AsyncHttpClient();
    client.post(url, params, new TextHttpResponseHandler() {
        @Override
        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            Log.d(TAG, "onFailure:CrachReporter " + throwable.toString());
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, String responseString) {


        }
    });