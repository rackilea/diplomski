private void go() throws Exception {
    final BufferedImage image = ImageIO.read(src);
    for (int i=0; i<100; ++i) {
        write(image);
        copy();
    }
}

private void write(BufferedImage image) throws Exception {
    final long start = System.nanoTime();
    ImageIO.write(image, "jpg", dst);
    final long end = System.nanoTime();
    System.out.format("write %15.6f\n", 1e-9 * (end-start));
}

private void copy() throws Exception {
    final long start = System.nanoTime();
    Files.copy(src.toPath(), dst.toPath(), StandardCopyOption.REPLACE_EXISTING);
    final long end = System.nanoTime();
    System.out.format("copy  %15.6f\n", 1e-9 * (end-start));
}