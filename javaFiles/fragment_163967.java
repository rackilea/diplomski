BufferedInputStream bis = new BufferedInputStream(url.openStream());
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
    "/tmp/output2.tmp"));

byte[] buffer = new byte[1024 * 1024];
int read = 0;
while ((read = bis.read(buffer)) != -1) {
  bos.write(buffer, 0, read);
}
bos.close();
bis.close();