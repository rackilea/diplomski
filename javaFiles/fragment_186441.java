try {
    ...
    final InputStream yourInputStream = ...; // InputStream from where to receive the map, in case of network you get it from the Socket instance.
    final ObjectInputStream mapInputStream = new ObjectInputStream(yourInputStream);
    final Map<A, B> yourMap = (Map) mapInputStream.readObject();
    ...
} finally {
    mapInputStream.close();
}