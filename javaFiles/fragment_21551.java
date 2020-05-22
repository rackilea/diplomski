public static BufferedImage read(URL input) throws IOException {
    if (input == null) {
        throw new IllegalArgumentException("input == null!");
    }

    InputStream istream = null;
    try {
        istream = input.openStream();
    } catch (IOException e) {
        throw new IIOException("Can't get input stream from URL!", e);
    }
}