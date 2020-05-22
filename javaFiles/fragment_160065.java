public BufferedImage toBufferedImage(Mat mat) {
    int type = BufferedImage.TYPE_BYTE_GRAY;
    if (mat.channels() > 1) {
        type = BufferedImage.TYPE_3BYTE_BGR;
    }
    byte[] bytes = new byte[mat.channels() * mat.cols() * mat.rows()];
    mat.get(0, 0, bytes);
    BufferedImage img = new BufferedImage(mat.cols(), mat.rows(), type);
    final byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
    System.arraycopy(bytes, 0, pixels, 0, bytes.length);
    return img;
}