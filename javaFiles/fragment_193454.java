InputStream in = new FileInputStream("filename");
StringBuilder sb = new StringBuilder();
byte[] b = new byte[4096];
for (int n; (n = in.read(b)) != -1;) {
    sb.append(new String(b, 0, n));
}
in.close();
String data = sb.toString();
data = data.replace("foo", "bar");
//do whatever you want with data