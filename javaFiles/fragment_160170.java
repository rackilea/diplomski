@RequestMapping(value = "/download", method = RequestMethod.GET)
public StreamingResponseBody download(@PathVariable String path) throws IOException {

    final InputStream fecFile = azureDataLakeStoreService.readFile(path);
    return (os) -> {
        readAndWrite(fecFile, os);
    };
}

private void readAndWrite(final InputStream is, OutputStream os)
        throws IOException {
    byte[] data = new byte[2048];
    int read = 0;
    while ((read = is.read(data)) >= 0) {
        os.write(data, 0, read);
    }
    os.flush();
}