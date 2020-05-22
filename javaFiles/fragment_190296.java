URL url = new URL("http://www.yahoo.com/image_to_read.jpg");
InputStream in = new BufferedInputStream(url.openStream());
ByteArrayOutputStream out = new ByteArrayOutputStream();
byte[] buf = new byte[1024];
int n = 0;
while (-1!=(n=in.read(buf)))
{
   out.write(buf, 0, n);
}
out.close();
in.close();
byte[] response = out.toByteArray();