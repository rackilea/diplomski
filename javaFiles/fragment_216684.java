byte[] contents = FileUtils.readFileToByteArray(new File(path));
File tmpFile = File.createTempFile("image", "png");
tmpFile.deleteOnExit();
InputStream in = new ByteArrayInputStream(contents);
FileOutputStream out = new FileOutputStream(tmpFile);
org.apache.commons.io.IOUtils.copy(in, out);