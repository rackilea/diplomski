public String uploadFile(String url, File f) throws Exception   {
    HttpClient httpClient = new DefaultHttpClient();    
    String str = "";
    HttpPost first = new HttpPost(url);  //a GET should work but I was getting 405
    HttpResponse firstResponse = httpClient.execute(first);
    str = firstResponse.getFirstHeader("Location").getValue();
    //Post image to generated url
    HttpPost second = new HttpPost(str);
    FileBody fileBody = new FileBody(f);
    MultipartEntity reqEntity = new MultipartEntity();
    reqEntity.addPart("file", fileBody);
    second.setEntity(reqEntity);
    httpClient = new DefaultHttpClient();
    HttpResponse secondResponse = httpClient.execute(second); 
    str = secondResponse.getFirstHeader("Location").getValue();
    log(str);
    return str;
}