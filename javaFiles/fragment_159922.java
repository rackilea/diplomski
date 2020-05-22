ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
GZIPInputStream gzipIn = new GZIPInputStream(bais);
ObjectInputStream objectIn = new ObjectInputStream(gzipIn);
MyObject myObj1 = (MyObject) objectIn.readObject();
MyObject myObj2 = (MyObject) objectIn.readObject();
objectIn.close();