public class ShapeReader {
    public static Shape readShape(InputStream inStream) {
        ... do the work
    }

    /*
     * @param fileName File name string. Must not be null or zero length.
     * @throws Exception if file specified by fileName fails to open
     */
    public static Shape readShape(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        try {
            return readShape(fis);
        } finally {
            fis.close();
        }
    }
}