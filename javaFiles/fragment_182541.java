public static bytes[] compressThis(Client client){
  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  GZIPOutputStream gzipOut = new GZIPOutputStream(client);
  ObjectOutputStream objectOut = new ObjectOutputStream(gzipOut);
  objectOut.writeObject(client);
  objectOut.close();
  return baos.toByteArray();
}