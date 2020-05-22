InputStream zipInputStream = ...
return new InputStream() {
    @Override
    public int read() throws IOException {
        return zipInputStream.read();
    }
    @Override
    public void close() throws IOException {
        zipInputStream.close();
        zipFile.close();
    }
}