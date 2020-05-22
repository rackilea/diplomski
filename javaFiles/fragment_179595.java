InputStream is = context.getResourceAsStream("Lenna32.png");
int nRead;
byte[] data = new byte[16 * 1024];
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
while ((nRead = is.read(data, 0, data.length)) != -1) {
    buffer.write(data, 0, nRead);
}
byte[] bytes = buffer.toByteArray();
Mat mat = imdecode(new Mat(bytes), CV_LOAD_IMAGE_UNCHANGED);