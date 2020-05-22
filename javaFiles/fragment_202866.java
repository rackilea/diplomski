private BufferedImage getBufferedImage(final File pFile)
        throws FileNotFoundException {
    Image icon = ShellFolder.getShellFolder(pFile).getIcon(true);
    BufferedImage im = new BufferedImage(icon.getWidth(null),
            icon.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = im.createGraphics();
    g.drawImage(icon, 0, 0, null);
    g.dispose();
    int width = im.getWidth();
    int height = im.getHeight();
    System.out.println(width);
    System.out.println(height);
    final int maxHeigh = 79;
    double scaleValue = 0;
    if (height > width)
        scaleValue = maxHeigh / height;
    else
        scaleValue = maxHeigh / width;
    final int scaledWidth = (int) (im.getWidth() * scaleValue);
    final int scaledHeigh = (int) (im.getHeight() * scaleValue);
    BufferedImage resized = new BufferedImage(scaledWidth, scaledHeigh,
            im.getType());
    g = resized.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(im, 0, 0, scaledWidth, scaledHeigh, 0, 0, im.getWidth(),
            im.getHeight(), null);
    g.dispose();
    return resized;
}