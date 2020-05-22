BufferedInputStream bis = new BufferedInputStream(is);
FileOutputStream fos = new FileOutputStream(file);
int current = 0;
byte[] buffer = new byte[1024];
while ((current = bis.read(buffer)) != -1) {
    fos.write(buffer, 0, current);
}
fos.close();
is.close();