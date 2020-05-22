Image image = new Image(...);
float alpha = 0.5;
@Override
public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
    g2d.setComposite(composite);
    g2d.drawImage(image, 0, 0, null);
}