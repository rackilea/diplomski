ByteArrayInputStream contentStream = new ByteArrayInputStream(base64Content.getBytes());
BASE64DecoderStream decodeStream = new BASE64DecoderStream(contentStream);
int decodedByte
while ((decodedByte = read()) != -1) {
   // handled decoded bytes
}