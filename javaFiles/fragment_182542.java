public static getClientFrom(bytes[] bytes){
  ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
  GZIPInputStream gzipIn = new GZIPInputStream(bais);
  ObjectInputStream objectIn = new ObjectInputStream(gzipIn);
  Client client = (Client) objectIn.readObject();
  objectIn.close();
  return client;
}