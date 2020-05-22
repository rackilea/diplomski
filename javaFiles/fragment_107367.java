private int uploadImage(String selectedImagePath) {

  try {
    HttpClient client = new DefaultHttpClient();
    File file = new File(selectedImagePath);
    HttpPost post = new HttpPost(Constants.URL);

    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,
                    Constants.BOUNDARY, Charset.defaultCharset());

    entity.addPart(Constants.MULTIPART_FORM_DATA_NAME, new FileBody(file));
    post.setHeader("Accept", "application/json");
    post.setHeader("Content-Type", "multipart/form-data; boundary=" + Constants.BOUNDARY);

    post.setEntity(entity);

    HttpResponse response = client.execute(post);
    HttpEntity httpEntity = response.getEntity();

    int status = response.getStatusLine().getStatusCode();

    return status;

  } catch (Exception e) {
    e.printStackTrace();
    return null;
  }
}