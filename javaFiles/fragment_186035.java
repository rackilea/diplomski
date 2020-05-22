public static BufferedImage mergeImages2(BufferedImage base, Collection<Light> images) {
    BufferedImage output = new BufferedImage(base.getWidth(), base.getHeight(), BufferedImage.TYPE_INT_ARGB);

    Graphics2D g = output.createGraphics();
    g.drawImage(base, 0, 0, null);
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 1.0f));
    for (Light l : images) {
        g.drawImage(l.LIGHT_IMAGE, l.x, l.y, null);
        l.LIGHT_IMAGE.flush();
    }
    g.dispose();
    output.flush();
    return output;
}