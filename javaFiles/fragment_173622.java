Pointer p = lzmaLib.lzma_uncompress(ptr, lzmaData.length, DECOMPRESSED_LENGTH, errorStatus); // DECOMPRESSED_LENGTH is a constant.

if (p != null) {
    byte[] decompressedData = p.getByteArray(0, DECOMPRESSED_LENGTH);
    System.out.println(new String(decompressedData, "ASCII")); // My data is ASCII text.
}

if (errorStatus != null) {
    int errorStatusCode = errorStatus.getInt(0);
    System.out.println("Error code: " + errorStatusCode);
}