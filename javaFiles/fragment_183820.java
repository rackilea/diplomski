HttpClient client = new DefaultHttpClient();
HttpPost httppost = new HttpPost("http://example.com/test");
MultipartEntity entity = new MultipartEntity();
entity.addPart("file1", new FileBody(new File("filetoUpload.jpg"), "application/jpg"));
post.setEntity(entity);
client.execute(post)
client.getConnectionManager().shutdown();