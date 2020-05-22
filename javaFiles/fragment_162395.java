HttpClient httpclient = new DefaultHttpClient();
    HttpGet get = new HttpGet(url);
    get.addHeader(new BasicHeader("Accept", "application/zip"));
    HttpResponse response = httpclient.execute(get);
    InputStream is = response.getEntity().getContent();
    ZipInputStream zip = new ZipInputStream(is);