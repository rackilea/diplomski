public class ShapeFileReader {
    private final InputStream inStream;

    public ShapeFileReader(InputStream inStream) {
        this.inStream = inStream;
    }

    /*
     * @param fileName File name string. Must not be null or zero length.
     * @throws Exception if file specified by fileName fails to open
     */
    public ShapeFileReader(String fileName) throws IOException {
        this(new FileInputStream(fileName));
    }