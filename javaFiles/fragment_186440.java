try {
    ...
    final Map<A, B> yourMap = ...; // Map to send
    final OutputStream yourOutputStream = ...; // OutputStream where to send the map in case of network you get it from the Socket instance.
    final ObjectOutputStream mapOutputStream = new ObjectOutputStream(yourOutputStream);
    mapOutputStream.writeObject(yourMap);
    ...
} finally {
    outputStream.close();
}