// Write an object to a ByteArrayOutputStream
ByteArrayOutputStream bout = new ByteArrayOutputStream();
ObjectOutputStream oout = new ObjectOutputStream(bout);
oout.writeObject(someObject);
oout.close();

// Read the object from the resulting array
ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
oin.readObject(); // Read the object we wrote in