InputStream is = Files.newInputStream(zipPath);
final File tempFile = File.createTempFile("PREFIX", "SUFFIX");
tempFile.deleteOnExit();
try (FileOutputStream out = new FileOutputStream(tempFile))
{
    IOUtils.copy(in, out);
}
// do something with tempFile