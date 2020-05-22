public String serializeArray(final String[] data) {
    try (final ByteArrayOutputStream boas = new ByteArrayOutputStream();
         final ObjectOutputStream oos = new ObjectOutputStream(boas)) {
        oos.writeObject(data);
        return Base64.getEncoder().encodeToString(boas.toByteArray());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}