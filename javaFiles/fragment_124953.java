public BufferedImage getQRCodeWithOverlay(BufferedImage qrcode) 
{
    BufferedImage scaledOverlay = scaleOverlay(qrcode);

    Integer deltaHeight = qrcode.getHeight() - scaledOverlay.getHeight();
    Integer deltaWidth  = qrcode.getWidth()  - scaledOverlay.getWidth();

    BufferedImage combined = new BufferedImage(qrcode.getWidth(), qrcode.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = (Graphics2D)combined.getGraphics();
    g2.drawImage(qrcode, 0, 0, null);
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, overlayTransparency));
    g2.drawImage(scaledOverlay, Math.round(deltaWidth/2), Math.round(deltaHeight/2), null);
    return combined;
}

private BufferedImage scaleOverlay(BufferedImage qrcode)
{
    Integer scaledWidth = Math.round(qrcode.getWidth() * overlayToQRCodeRatio);
    Integer scaledHeight = Math.round(qrcode.getHeight() * overlayToQRCodeRatio);

    BufferedImage imageBuff = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics g = imageBuff.createGraphics();
    g.drawImage(overlay.getScaledInstance(scaledWidth, scaledHeight, BufferedImage.SCALE_SMOOTH), 0, 0, new Color(0,0,0), null);
    g.dispose();
    return imageBuff;
}