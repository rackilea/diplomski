InputStream in = url.openStream();
OutputStream out = new FileOutputStream(name + (fileNumber+i) + ".html");

byte[] buffer = new byte[1024*1024];
int len;
while ((len = in.read(buffer)) != -1) {
    out.write(buffer, 0, len);
}