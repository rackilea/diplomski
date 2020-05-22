private void writeObject(ObjectOutputStream outStream) throws IOException {
    //write attributes from PersonYo only
    outStream.defaultWriteObject();
    outStream.writeObject(sObj1);
    outStream.writeObject(sObj2);
    outStream.writeObject(sObj2);
 }

private void readObject(ObjectInputStream inStream) throws IOException,
                                                          ClassNotFoundException {
    //read attributes from PersonYo only
    inStream.defaultReadObject();
    sObj1= (SerializableObj)inStream.readObject();
    sObj2= (SerializableObj)inStream.readObject();
    sObj3= (SerializableObj)inStream.readObject();
}