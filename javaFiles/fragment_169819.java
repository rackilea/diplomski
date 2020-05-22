// Serialize to a byte array
ByteArrayOutputStream bStream = new ByteArrayOutputStream();
ObjectOutput oo = new ObjectOutputStream(bStream); 
oo.writeObject(messageClass);
oo.close();

byte[] serializedMessage = bStream.toByteArray();