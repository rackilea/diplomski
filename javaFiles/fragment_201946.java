HttpPost post = new HttpPost("www.google.com");
post.setHeader(new BasicHeader("User-Agent", "random client"));
HttpEntity entity = new StringEntity("yellaworld");
post.setEntity(entity);
Header[] headers = post.getAllHeaders();
String content = EntityUtils.toString(entity);

System.out.println(post.toString());
for (Header header : headers) {
    System.out.println(header.getName() + ": " + header.getValue());
}
System.out.println();
System.out.println(content);