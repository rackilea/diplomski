String trimByBytes(String str, int lengthOfBytes) {
    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
    ByteBuffer buffer = ByteBuffer.wrap(bytes);

    if (lengthOfBytes < buffer.limit()) {
        buffer.limit(lengthOfBytes);
    }

    CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
    decoder.onMalformedInput(CodingErrorAction.IGNORE);

    try {
        return decoder.decode(buffer).toString();
    } catch (CharacterCodingException e) {
        // We will never get here.
        throw new RuntimeException(e);
    }
}