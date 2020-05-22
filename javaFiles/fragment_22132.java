public class MyAsyncHttpClient extends AsyncHttpClient {
    private static MyAsyncHttpClient client;

    private MyAsyncHttpClient() {

    }

    public static MyAsyncHttpClient getClient() {
        if (client == null) {
            client = new MyAsyncHttpClient();
            // do whatever, setCookieStore, addHeader, etc
        }      


        return client;
    }
}