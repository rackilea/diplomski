byte[] youByteArray;

ByteArrayInputStream in = new ByteArrayInputStream(youByteArray);
ObjectInputStream is = new ObjectInputStream(in);
// Will throw compiler warnings but should work fine.
Vector<String> yourVector = (Vector<String>) is.readObject();