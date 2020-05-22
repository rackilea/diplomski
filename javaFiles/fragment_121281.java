value.ifPresent(v -> {
    try {
        gen.writeObject(v);
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
});