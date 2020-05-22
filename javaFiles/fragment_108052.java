ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(myObject);
oos.flush();
byte[] binary = baos.toByteArray();
String text = Base64.encodeBase64String(binary); // Base64 is in the apache commons codec library
// save text to a file