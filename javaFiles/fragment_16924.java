private int getMessageSizeInBytes(MessageWrapper message) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(message);
    oos.close();
    return baos.size();
}