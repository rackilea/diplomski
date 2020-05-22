final URL url = ModelCodeGenerator.class.getClassLoader()
    .getResource("/model.java.txt");

if (url == null)
    throw new IOException("resource not found");

try (
    final InputStream in = url.openStream();
    final Reader reader = new InputStreamReader(in, someCharsetOrDecoder);
) {
    // manipulate resources
}