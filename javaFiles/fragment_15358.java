try (
    OutputStream outputStream = new FileOutputStream(createdFile);
    GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
    OutputStreamWriter osw = new OutputStreamWriter(gzipOutputStream);
    BufferedWriter bw = new BufferedWriter(osw)
    ) {
    // ...
}