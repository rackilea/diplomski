public class ResetOnCloseInputStream extends BufferedInputStream {

    public ResetOnCloseInputStream(InputStream is) {
        super(is);
        super.mark(Integer.MAX_VALUE);
    }

    @Override
    public void close() throws IOException {
        super.reset();
    }

}