public class Foo implements Callable<String> {

    @Override
    public String call() {
        String result = null;
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000);
        HttpResponse response;

        try {
            HttpPost post = new HttpPost("http://www.example.com/json_android.php");
            StringEntity se = new StringEntity( json.toString());
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            post.setEntity(se);
            response = client.execute(post);
            if(response!=null){
                InputStream stream = response.getEntity().getContent();
                result = convertToString(stream);

                /*
                     I can Log result with below line
                */
                Log.e("response is: ", result);

                /*
                     result is {"username = ":"Hello"}
                */
            }

        } catch(Exception e) {
            e.printStackTrace();
            Log.e("Error", String.valueOf(e));
        }
        return result;
    }
}