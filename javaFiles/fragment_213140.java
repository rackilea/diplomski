public Stream<Object> toStream(final ObjectInputStream stream) {
    return Stream.generate(() -> readObject(stream)).onClose(
        () -> close(stream));
}

private static Object readObject(ObjectInputStream stream) {
    try {
        return stream.readObject();
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}

private static void close(Closeable c) {
    try {
        c.close();
    } catch (IOException e) {
        logger.log(Level.WARNING, "Couldn't close " + c, e);
    }
}