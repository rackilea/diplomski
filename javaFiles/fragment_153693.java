HttpClient client=null;
byte b[]= new byte[1000];
MultipartEntity form = new MultipartEntity();
ContentBody cd = new InputStreamBody(new ByteArrayInputStream(b), "my-file.txt");
form.addPart("file", cd);

HttpEntityEnclosingRequestBase post = new HttpPost("");//If a PUT request then `new HttpPut("");`
post.setEntity(form);
client.execute(post);