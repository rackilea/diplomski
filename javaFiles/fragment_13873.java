public class HandPanel extends JPanel {

    CardImage cardImage;

    public HandPanel(Card card) {
        cardImage = new CardImage(card);
    }

    @Override
    public Dimension getPreferredSize() {
        BufferedImage img = cardImage.getImage();
        return img == null ? super.getPreferredSize() : new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = cardImage.getImage();
        g.drawImage(img, 0, 0, this);
    }

}