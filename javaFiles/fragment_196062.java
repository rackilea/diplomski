byte[] bytes;
synchronized (baos) {
    bytes = baos.toByteArray();
    baos.reset();
}
if (bytes.length > ) { ...