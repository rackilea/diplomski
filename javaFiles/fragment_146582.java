private static OutputStream convertStringtoStream(String string) {
    byte[] stringByte = string.getBytes();
    ByteArrayOutputStream bos = new ByteArrayOutputStream(string.length());
    bos.write(stringByte);
    return bos;
}