class A extends FileInputStream {
    public A(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public synchronized void mark(int readlimit) {
        super.mark(readlimit);
    }

    @Override
    public long skip(long n) throws IOException {
        return super.skip(n);
    }
}