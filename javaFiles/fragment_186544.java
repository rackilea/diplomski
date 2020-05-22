String specificPath = "some/path/in/zip/";

ZipFile zipFile = new ZipFile(file);
Enumeration<? extends ZipEntry> entries = zipFile.entries();
while (entries.hasMoreElements()) {
    ZipEntry ze = entries.nextElement();
    if (ze.getName().startsWith(specificPath)) {
        System.out.println(ze);
    }
}