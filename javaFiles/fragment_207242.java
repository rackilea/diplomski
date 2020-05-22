PostMethod post = new PostMethod("http://jakarata.apache.org/");
NameValuePair[] data = {
  new NameValuePair("user", "joe"),
  new NameValuePair("password", "bloggs")
};
post.setRequestBody(data);
// execute method and handle any error responses.
...
InputStream in = post.getResponseBodyAsStream();
// handle response.