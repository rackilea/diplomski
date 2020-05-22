ByteArrayInputStream is = new ByteArrayInputStream(compressed);
    GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
    byte[] data = new byte[BUFFER_SIZE];
    int bytesRead;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    while ((bytesRead = gis.read(data)) != -1) {
        baos.write(data, 0, bytesRead);
    }
    gis.close();
    is.close();
    return baos.toString("UTF-8");