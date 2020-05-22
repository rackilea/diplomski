String urlAdd = "https://api.twitter.com/1/following/ids.json?user_id=1000123";
URL url = new URL(urlAdd);
URLConnection urlConnection = url.openConnection();
HttpURLConnection httpConn = (HttpURLConnection)urlConnection;
InputStream is;
if (httpConn.getResponseCode() >= 400) {
    is = httpConn.getErrorStream();
} else {
    is = httpConn.getInputStream();
}
BufferedReader in = new BufferedReader(new InputStreamReader(is));