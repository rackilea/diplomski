@Test
public void parseHttp() throws Exception {

    AsyncHttpClient client = new AsyncHttpClient();
    final CountDownLatch latch = new CountDownLatch(1);

    String url = "http://stackoverflow.com/questions/38959381/unable-to-scrape-data-from-internet-using-android-intents";

    client.get(url, new AsyncHttpResponseHandler(Looper.getMainLooper()) {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String body = new String(responseBody);
            Pattern p = Pattern.compile("<h1(.*)<\\/h1>");
            Matcher m = p.matcher(body);
            Log.d("tag", "success");
            if ( m.find() ) {
                String match = m.group(1);
                Log.d("tag", match);
            }
            latch.countDown();
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            Log.d("tag", "failure");
            latch.countDown();
        }
    });

    latch.await();
}