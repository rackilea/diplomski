public static BufferedImage convertMatToBufferedImage(Mat m){
    byte [] buffer = new byte[m.channels()*m.cols()*m.rows()];
    m.get(0, 0, buffer); 
    BufferedImage image = new BufferedImage(m.cols(), m.rows(), BufferedImage.TYPE_BYTE_GRAY);
    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);     
    return image;
}

public static Image convertMatToImage(Mat m) {
    if (m == null || m.width() == 0 || m.height() == 0) return null;
    Mat resultMat = m.clone();
    WritableImage image = new WritableImage(m.width(), m.height());
    byte[] data = new byte[m.cols() * m.rows() * 3]; // * 3 because Image needs 3 bytes per pixel even if grayscale

    if (resultMat.channels() == 1)
        Imgproc.cvtColor(resultMat, resultMat, Imgproc.COLOR_GRAY2RGB);
    else if (resultMat.channels() == 3)
        Imgproc.cvtColor(resultMat, resultMat, Imgproc.COLOR_BGR2RGB);

    resultMat.get(0, 0, data);
    image.getPixelWriter().setPixels(0, 0, m.width(), m.height(), PixelFormat.getByteRgbInstance(), data, 0, m.width() * 3);
    return image;
}