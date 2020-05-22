public class OpenHttpConnection extends AsyncTask<String, Void, InputStream> {

    @Override
    protected String doInBackground(String... params) {
      String urlstring = params[0];
      InputStream in = null;
      int response = 01;

      URL url = new URL(urlString);
      URLConnection conn = url.openConnection();

      if (!(conn instanceof HttpURLConnection))
        throw new IOException("Not an HTTP connection");
      try{
        HttpURLConnection httpConn = (HttpURLConnection) conn;
        httpConn.setAllowUserInteraction(false);
        httpConn.setInstanceFollowRedirects(true);
        httpConn.setRequestMethod("Get");
        httpConn.connect();
        response = httpConn.getResponseCode();
        if (response == HttpURLConnection.HTTP_OK){
          in = httpConn.getInputStream();
        }
      }
      catch (Exception ex)
      {
        throw new IOException("Error connecting");
      }
      return in;

    }

}