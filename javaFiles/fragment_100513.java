MyClass obj = ....;
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(obj); // this is what you already have.
int size = baos.length; // now we have size

OutputStream socketStream = .... // I guess you know how to get it. 
ObjectOutputStream socketOos = new ObjectOutputStream(socketStream);
socketOos.writeInt(size);
socketOos.write(baos.toByteArray());