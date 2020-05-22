@Override
public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    AffineTransform xform = AffineTransform.getScaleInstance(.5, .5);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(image, xform, null); // image being @2x or "retina" size
}