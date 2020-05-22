list.stream()
    .map(BuildArrayBytes.safeChunk())
    .filter(Objects::nonNull)               // Be careful! Filter out invalid (null) chunks
    .forEach(byteArrayOutputStream::write);

...

private static Function<SomeObject, Integer> safeChunk() {
    return i -> {
        try {
            return i.getChunk();
        } catch (IOException e) {
            /* handle properly */
        }
        return null;
    };
}