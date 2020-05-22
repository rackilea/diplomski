public void getContents() throws IOException {
    HttpClient httpClient = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet(this.urlToPage);
    HttpResponse response = httpClient.execute(httpGet);
    HttpEntity entity = response.getEntity();
    IOUtils.copy(entity.getContent(), new FileOutputStream(this.saveToFileName));
}