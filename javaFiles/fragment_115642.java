public static String get(String url) throws IOException {

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    URLConnection conn=null;
    byte[] buf = new byte[4096];

    try {
        URL a = new URL(url);
        conn = a.openConnection();
        InputStream is = conn.getInputStream();
        int ret = 0;
        while ((ret = is.read(buf)) > 0) {
            os.write(buf, 0, ret);
        }
        // close the inputstream
        is.close();
        return new String(os.toByteArray());
    } catch (IOException e) {
        try {
            int respCode = ((HttpURLConnection)conn).getResponseCode();
            InputStream es = ((HttpURLConnection)conn).getErrorStream();
            int ret = 0;
            // read the response body
            while ((ret = es.read(buf)) > 0) {
                os.write(buf, 0, ret);
            }
            // close the errorstream
            es.close();
            return "Error response " + respCode + ": " + 
               new String(os.toByteArray());
        } catch(IOException ex) {
            throw ex;
        }
    }
}