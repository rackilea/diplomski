// encoding
Map<Integer, Map<String,String>> mimss =new HashMap<Integer, Map<String,String>>();
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(bos);
oos.writeObject(mimss);
oos.flush();
oos.close();
bos.close();
byte[] byteData = bos.toByteArray();
String serial= DatatypeConverter.printBase64Binary(byteData);

// decoding
byte[] byteData_reverse=DatatypeConverter.parseBase64Binary(serial);
ByteArrayInputStream bais = new ByteArrayInputStream(byteData_reverse);
Map<Integer, Map<String,String>> mimss_copy=(Map<Integer,Map<String,String>>) new ObjectInputStream(bais).readObject();