ZipEntry entry = entries.nextElement();
if (!entry.isDirectory()) {
    InputStream stream = zipFile.getInputStream(entry);
...
    stream.close();
}