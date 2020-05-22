short[] depth = myKinect.getDepthFrame();
int DHeight = 424;
int DWidth = 512;
int dx = 0;
int dy = 21;

BufferedImage bufferDepth = new BufferedImage(DWidth, DHeight, BufferedImage.TYPE_USHORT_GRAY);

for (int j = 0; j < DHeight; j++) {
    for (int i = 0; i < DWidth; i++) {
        int index = i + j * DWidth;
        short value = depth[index];
        Color color = new Color(value, value, value);
        bufferDepth.setRGB(i, j, color.getRGB());
    }
}

try {
    ImageIO.write(bufferDepth, "jpg", outputFileD);
} catch (IOException e) {
    e.printStackTrace();
}