protected String uploadBytesForCsv(Map<Integer, Map<Integer, Object>> rows) throws IOException {
    LOGGER.info("Get Bytes For Csv");

    final Collection<String> lines = cellsToCsv(rows);
    LOGGER.info("number line : " + lines.size());

    boolean firstElement = true;

    final String fileName = getFileName();

    final GcsFilename gcsFilename = new GcsFilename(config.getBucketName(), fileName);
    final GcsService gcsService = GcsServiceFactory.createGcsService();
    final GcsOutputChannel outputChannel = gcsService.createOrReplace(gcsFilename, GcsFileOptions.getDefaultInstance());

    for (final String part : lines) {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        String value = part + LINE_SEPARATOR;
        if (firstElement) {
            value = addExcelPrefix(value);
            firstElement = false;
        }

        final int currentSize = value.length();
        try {
            stream.write(value.getBytes(ENCODING), 0, currentSize);
            outputChannel.write(ByteBuffer.wrap(stream.toByteArray()));
        } catch (UnsupportedEncodingException e) {
            LOGGER.info(e.getMessage());
        }

        stream.flush();
        stream.close();
    }

    outputChannel.close();

    return new UrlBuilder(config.getStorageUrlForExport())
            .setBucketName(config.getBucketName())
            .setFilename(fileName).build();
}