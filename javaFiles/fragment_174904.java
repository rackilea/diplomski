// A ByteArrayOutputStream holds the content in memory
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

// Do stuff with your OutputStream

// To convert it to a byte[] - simply use
final byte[] bytes = outputStream.toByteArray();

// To convert bytes to an InputStream, use a ByteArrayInputStream
ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);