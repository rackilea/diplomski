URL url = new URL("http://www.example.com/");
URLConnection con = url.openConnection();
InputStream in = con.getInputStream();
String encoding = con.getContentEncoding();
encoding = encoding == null ? "UTF-8" : encoding;
String body = IOUtils.toString(in, encoding);
System.out.println(body);