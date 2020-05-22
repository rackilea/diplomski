class FileInputStreamInh extends FileInputStream {

    public FileInputStreamInh(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void close() throws IOException {
        super.close();
        ^^^breakpoint here
    }
}