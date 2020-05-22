public class ImmediateResilientFileOutputStream extends OutputStream {

    // merged code from ResilientOutputStreamBase and ResilientFileOutputStream

    protected FileOutputStream os;

    public FileOutputStream openNewOutputStream() throws IOException {
        return new FileOutputStream(file, true);
    }

    @Override
    public void flush() {
        if (os != null) {
            try {
                os.flush();
                os.getFD().sync(); // this's make sence
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        }
    }

}