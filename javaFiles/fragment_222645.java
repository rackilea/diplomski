// Get the response
InputStream is;
if (((HttpURLConnection) conn).getResponseCode() == 400)
    is = ((HttpURLConnection) conn).getErrorStream();
else
    is = conn.getInputStream();

BufferedReader rd = new BufferedReader(new InputStreamReader(is));