public static int httpGet(String url, StringBuilder response) throws IOException {
    return httpGet(URL, response, 5000)
}

public static int httpGet(String url, StringBuilder response, int readTimeout) throws IOException {
    return http(url,(http)->http.setRequestMethod("GET"), response, readTimeout);
}


private static int http(String url, httpMethod method, StringBuilder response) throws IOException {
    return http(url, method, response, 5000);
}

private static int http(String url, httpMethod method, StringBuilder response, int readTimeout) throws IOException {
    HttpURLConnection http = (HttpURLConnection)new URL(url).openConnection();
    http.setConnectTimeout(5000);
    http.setReadTimeout(readTimeout;
    method.doMethod(http);
    int status = 404;
    ......
    ......
    return status;
}