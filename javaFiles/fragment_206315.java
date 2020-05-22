public long[] getByteRangeBySignatureOffset(long signatureOffset) throws IOException {
    source.seek(signatureOffset);
    skipID();
    byteRange[0] = 0;
    parseDictionary();
    byteRange[3] = getOffsetOfNextEOF(byteRange[2]) - byteRange[2];
    return byteRange;
}

private long getOffsetOfNextEOF(long currentOffset) throws IOException {
    byte[] buffer = new byte[EOF_STRING.length];
    source.seek(currentOffset + document.getHeader().getHeaderOffset());
    source.read(buffer);
    source.unread(buffer.length - 1);
    while (!Arrays.equals(buffer, EOF_STRING)) {    //TODO: does it need to be optimized?
        source.read(buffer);
        if (source.isEOF()) {
            source.seek(currentOffset + document.getHeader().getHeaderOffset());
            return source.getStreamLength();
        }
        source.unread(buffer.length - 1);
    }
    long result = source.getOffset() - 1 + buffer.length;   // byte right after 'F'
    source.seek(currentOffset + document.getHeader().getHeaderOffset());
    return result - 1;
}