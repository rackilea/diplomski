ContentReader reader = contentService.getReader(nodeRef, ContentModel.PROP_CONTENT);
InputStream originalInputStream = reader.getContentInputStream();
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
final int BUF_SIZE = 1 << 8; //1KiB buffer
byte[] buffer = new byte[BUF_SIZE];
int bytesRead = -1;
while((bytesRead = originalInputStream.read(buffer)) > -1) {
    outputStream.write(buffer, 0, bytesRead);
}
originalInputStream.close();
byte[] binaryData = outputStream.toByteArray();