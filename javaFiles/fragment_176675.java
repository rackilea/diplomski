public static HttpConnection getHttpConnection(String url, byte[] postData) {
    HttpConnection conn = null;
    OutputStream out = null;
    try {
        conn = (HttpConnection) new ConnectionFactory().getConnection(url).getConnection();
        if (conn != null) {
            if (postData == null) {
                conn.setRequestMethod(HttpConnection.GET);
                conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.0");
            } else {
                conn.setRequestMethod(HttpConnection.POST);
                conn.setRequestProperty("Content-Length", String.valueOf(postData.length));
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.0");

                out = conn.openOutputStream();
                out.write(postData);
                out.flush();
            }
            if (conn.getResponseCode() != 0) {
                return conn;
            }
        }
    } catch (Exception e) {
    } finally {
        try {
            out.close();
        } catch (Exception e2) {
        }
    }

    //Only if exception occurs, we close the connection.
    //Otherwise the caller should close the connection himself.
    try {
        conn.close();
    } catch (Exception e1) {
    }
    return null;
}