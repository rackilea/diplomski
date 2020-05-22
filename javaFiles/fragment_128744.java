InputStream in = new FileInputStream( in.toFile() );
ByteArrayOutputStream out = new ByteArrayOutputStream();
byte[] buf = new byte[4096];
int len;
while ((len = in.read(buf)) > 0) {
    out.write(buf,0,len);
}