URLConnection conn;

// ...

conn = new URL(...).openConnection();

// ...

if (conn instanceof HttpsURLConnection) {
    HttpsURLConnection httpsConn = (HttpsURLConnection) conn;
    httpsConn.setHostnameVerifier(...);
}

// ...