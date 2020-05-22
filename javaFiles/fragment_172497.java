ZipFile zipFile = new ZipFile(strFilePath + ".zip");
Enumeration<? extends ZipEntry> entries = zipFile.entries();
while(entries.hasMoreElements()) {
    ZipEntry entry = entries.nextElement();
    System.err.println(entry.getName());
}