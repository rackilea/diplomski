// ...

if (conn instanceof HttpsURLConnection) {
    ((HttpsURLConnection) conn).setHostnameVerifier(...);
}

// ...