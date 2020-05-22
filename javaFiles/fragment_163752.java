ByteArrayOutputStream baos = new ByteArrayOutputStream();
try {
    ...
} finally {
    baos.close();
}
byte[] bytes = baos.toByteArray();
...