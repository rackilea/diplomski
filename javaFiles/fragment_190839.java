public static byte[] YV12toYUV420Planar(byte[] input, byte[] output, int width, int height) {
    final int frameSize = width * height;
    final int qFrameSize = frameSize/4;

    System.arraycopy(input, 0, output, 0, frameSize); // Y
    System.arraycopy(input, frameSize, output, frameSize + qFrameSize, qFrameSize); // Cr (V)
    System.arraycopy(input, frameSize + qFrameSize, output, frameSize, qFrameSize); // Cb (U)

    return output;
}