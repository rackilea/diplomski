public Mat fromBufferedImage(BufferedImage img) {
    byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
    Mat mat = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
    mat.put(0, 0, pixels);
    return mat;
}