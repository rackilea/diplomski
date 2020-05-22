byte[] bytesToRead;
ByteArrayInputStream arrInStream = new ByteArrayInputStream(bytesToRead);
try {
    ObjectInputStream objectInStream = new ObjectInputStream(arrInStream);
    contact = (Contact) objectInStream.readObject();
} catch (Exception e) {
    e.printStackTrace();
}