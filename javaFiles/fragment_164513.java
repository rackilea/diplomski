// Create access to zip.
FileSystemManager fsManager = VFS.getManager();
FileObject zipFile = fsManager.resolveFile("file:/path/to/the/file.zip");
zipFile.createFile();
ZipOutputStream zos = new ZipOutputStream(zipFile.getContent().getOutputStream());

// add entry/-ies.
ZipEntry zipEntry = new ZipEntry("name_inside_zip");
FileObject entryFile = fsManager.resolveFile("file:/path/to/the/sourcefile.txt");
InputStream is = entryFile.getContent().getInputStream();

// Write to zip.
byte[] buf = new byte[1024];
zos.putNextEntry(zipEntry);
for (int readNum; (readNum = is.read(buf)) != -1;) {
   zos.write(buf, 0, readNum);
}