StringBuilder s = new StringBuilder();
byte[] buffer = new byte[1024];
int read = 0;
ZipEntry entry;
while ((entry = zis.getNextEntry())!= null) {
      while ((read = zis.read(buffer, 0, 1024)) >= 0) {
           s.append(new String(buffer, 0, read));
      }
}