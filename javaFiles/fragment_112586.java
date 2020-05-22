byte[] buf=new byte[1024];
int bytes_read;
OutputStream out = new FileOutputStream("capture.ogg", true);
InputStream in = sock.getInputStream();
while ((bytes_read = in.read(buf)) != -1) {
    out.write(buf, 0, bytes_read);
}
out.close();