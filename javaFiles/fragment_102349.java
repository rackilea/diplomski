HttpPost post = new HttpPost(uri);
MultipartEntity entity = new MultipartEntity();

for (NameValuePair param : params) {
    entity.addPart(param.getName(), new StringBody(param.getValue()));
}

post.setEntity(entity);

try {
    HttpResponse response = client.execute(post);
    // do something with the response
} catch (ClientProtocolException ex | IOException ex) {
    // deal with exception
}