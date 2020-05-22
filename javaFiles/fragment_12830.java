public class GetFileHandler extends FileHandler {

    public GetFileHandler() throws IOException {
        super();
    }

    /**
     * Gets the files used by this handler.  Index zero is the file that is
     * in use.
     *
     * @return a array of files.
     * @throws IOException if there is an error.
     * @throws SecurityException if not allowed.
     */
    public File[] getFiles() throws IOException {
        return GetFileHandler.getFiles(this);
    }

    private static File[] getFiles(FileHandler h) throws IOException {
        try {
            Field f = FileHandler.class.getDeclaredField("files");
            f.setAccessible(true);
            synchronized (h) {
                return ((File[]) f.get(h)).clone();
            }
        } catch (ReflectiveOperationException roe) {
            throw new IOException(roe);
        }
    }
}