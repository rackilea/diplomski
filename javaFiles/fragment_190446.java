public static String Decompress(String zipText) throws IOException {
    byte[] gzipBuff = Base64.decodeBase64(zipText);

    ByteArrayInputStream memstream = new ByteArrayInputStream(gzipBuff);
    GZIPInputStream gzin = new GZIPInputStream(memstream);

    final int buffSize = 8192;
    byte[] tempBuffer = new byte[buffSize ];
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    while ((size = gzin.read(tempBuffer, 0, buffSize)) != -1) {
        baos.write(tempBuffer, 0, size);
    }        
    byte[] buffer = baos.toByteArray();
    baos.close();

    return new String(buffer, "UTF-8");
}