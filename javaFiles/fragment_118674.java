public static ImageIcon createImageIcon(final String path) {
    InputStream is = ImageLoader.class.getResourceAsStream(path);
    int length;
    try {
        length = is.available();
        byte[] data = new byte[length];
        is.read(data); 
        is.close();
        ImageIcon ii = new ImageIcon(data);
        return ii;
    } catch (IOException e) {
        LogManager.logCriticalProblem("Image not found at {} - {}", new Object[]{path, e.getMessage()});
    }
    return null;
}