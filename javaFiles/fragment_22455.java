private static int getFileSize(URL url) {
    URLConnection conn = null;
    try {
        conn = url.openConnection();
        if(conn instanceof HttpURLConnection) {
            ((HttpURLConnection)conn).setRequestMethod("HEAD");
        }
        conn.getInputStream();
        return conn.getContentLength();
    } catch (IOException e) {
        throw new RuntimeException(e);
    } finally {
        if(conn instanceof HttpURLConnection) {
            ((HttpURLConnection)conn).disconnect();
        }
    }
}