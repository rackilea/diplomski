String filename = FilenameUtils.getName(fileItem.getName()); // Important!
File destination = new File("D:/path/to/files", filename);

InputStream input = null;
OutputStream output = null;

try {
    input = fileItem.getInputStream();
    output = new FileOutputStream(destination);
    IOUtils.copy(input, output);
} finally {
    IOUtils.closeQuietly(output);
    IOUtils.closeQuietly(input);
}