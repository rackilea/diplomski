BufferedImage changeOpacity(BufferedImage img, int opacity) {
    final BufferedImage ret = new BufferedImage(img.getWidth(),
                                                img.getHeight(),
                                                BufferedImage.TYPE_INT_ARGB);
    final RescaleOp ro = new RescaleOp(new float[] {1f, 1f, 1f, ((float)opacity)/255f},
                                       new float[] {0f, 0f, 0f, 0f},
                                       null);
    ro.filter(img, ret);
    return ret;
}