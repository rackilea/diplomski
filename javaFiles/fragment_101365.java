ProxyInputStreamis = new ProxyInputStream(fds.getFileStream(p)) {
    @Override
    public void close() throws IOException {
            super.close();
            // some trigger
    }
 };