public boolean isCharset(final Charset charset, final byte[] contents)
    throws IOException
{
    final CharsetDecoder decoder = charset.newDecoder()
        .onMalformedInput(CodingErrorAction.REPORT);
    final ByteBuffer buf = ByteBuffer.wrap(contents);

    try {
        decoder.decode(buf);
        return true;
    } catch (CharacterCodingException ignored) {
        return false;
    }
}