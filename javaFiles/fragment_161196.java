public String[] deserializeArray(final String data) {
    try (final ByteArrayInputStream bias = new ByteArrayInputStream(Base64.getDecoder().decode(data));
         final ObjectInputStream ois = new ObjectInputStream(bias)) {
        return (String[]) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}