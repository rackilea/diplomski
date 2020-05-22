URL url = new URL("http://example.com/path/to/archive");
ZipInputStream zin = new ZipInputStream(url.getInputStream());
ZipEntry ze = zin.getNextEntry();
while (!ze.getName().equals(pathToFile)) {
    zin.closeEntry(); // not sure whether this is necessary
    ze = zin.getNextEntry();
}
byte[] bytes = new byte[ze.getSize()];
zin.read(bytes);