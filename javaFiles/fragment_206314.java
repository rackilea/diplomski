public long[] getByteRangeBySignatureOffset(long signatureOffset) throws IOException {
    pdfSource.seek(signatureOffset);
    skipID();
    byteRange[0] = 0;
    parseDictionary();
    byteRange[3] = getOffsetOfNextEOF(byteRange[2]) - byteRange[2];
    return byteRange;
}

private long getOffsetOfNextEOF(long currentOffset) throws IOException {
    byte[] buffer = new byte[EOF_STRING.length];
    pdfSource.seek(currentOffset + document.getHeaderOffset());
    readWholeBuffer(pdfSource, buffer);
    pdfSource.rewind(buffer.length - 1);
    while (!Arrays.equals(buffer, EOF_STRING)) {    //TODO: does it need to be optimized?
        readWholeBuffer(pdfSource, buffer);
        if (pdfSource.isEOF()) {
            pdfSource.seek(currentOffset + document.getHeaderOffset());
            return pdfSource.length();
        }
        pdfSource.rewind(buffer.length - 1);
    }
    long result = pdfSource.getPosition() + buffer.length - 1;  // offset of byte after 'F'
    pdfSource.seek(currentOffset + document.getHeaderOffset());
    return result - 1;
}