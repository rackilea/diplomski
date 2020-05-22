private byte[] getObjectAsBytes(Data data) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
        data.writeObject(oos);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return bos.toByteArray();
}