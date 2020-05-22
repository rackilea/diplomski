ZipFile zipFile = new ZipFile("archive.zip");
Enumeration<? extends ZipEntry> e = zipFile.entries();
while (e.hasMoreElements()) {
  ZipEntry entry = e.nextElement();
  if (entry.getName().startswit(".ebextensions/") && ! entry.isDirectory()) {
    // procss file 
  }
}