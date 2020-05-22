class WebService {
    public void getUrl(String url, final Context mContext, WebServiceCallback cb) {
    AsyncHttpClient client = new AsyncHttpClient();
            client.get(url, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                cb.onFailure();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                cb.onSuccess(responseString);
            }
        });
 }

   public interface WebServiceCallback{
      void onFailure();
      void onSuccess(String url);
  }
}