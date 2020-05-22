private RandomAccessFile getRandomAccessFile() {
    RandomAccessFile raf = null;
    try {
        raf = new RandomAccessFile(path, "r");
        raf.order(RandomAccessFile.BIG_ENDIAN);
    } catch (IOException e) {
        logger.error("Error opening file " + path, e);
    }
    return raf;
}