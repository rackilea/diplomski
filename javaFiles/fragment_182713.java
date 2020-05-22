HttpClient httpClient = createHttpClient();
HttpPost httpost = new HttpPost(url);
HttpResponse response = null;
try {
    response = httpClient.execute(httpost);
    StatusLine statusLine = response.getStatusLine();
} catch (IOException e) {
    e.printStackTrace();
}