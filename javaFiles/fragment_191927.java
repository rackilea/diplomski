ByteArrayOutputStream arrOutStream = new ByteArrayOutputStream();
try {
    ObjectOutputStream out = new ObjectOutputStream(arrOutStream);
    out.writeObject(contact);
    byte[] bytes = arrOutStream.toByteArray();
} catch (IOException e) {
    e.printStackTrace();
}