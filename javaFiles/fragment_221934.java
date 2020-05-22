InputStream input = null;
OutputStream output = null;

try {
    input = new BufferedInputStream(resultSet.getBinaryStream("columnName"), DEFAULT_BUFFER_SIZE);
    output = new ByteArrayOutputStream();
    byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

    for (int length; ((length = input.read(buffer)) > 0;) {
        output.write(buffer, 0, length);
    }
} finally {
    if (output != null) try { output.close(); } catch (IOException ignore) {}
    if (input != null) try { input.close(); } catch (IOException ignore) {}
}

Image image = new Image();
image.setPhoto(new ByteArrayInputStream(output.toByteArray()));
// ...