ByteArrayOutputStream baos = new ByteArrayOutputStream();
GZIPOutputStream gzipOut = new GZIPOutputStream(baos);
ObjectOutputStream objectOut = new ObjectOutputStream(gzipOut);
objectOut.writeObject(myObj1);
objectOut.writeObject(myObj2);
objectOut.close();
byte[] bytes = baos.toByteArray();