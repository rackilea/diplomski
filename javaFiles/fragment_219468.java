class MyZIS extends ZipInputStream {

    public MyZIS(InputStream in) {
        super(in);
    }

    @Override
    public void close() throws IOException {
    }

    public void myClose() throws IOException {
        super.close();
    }
}