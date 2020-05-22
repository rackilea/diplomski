public CardImagePane getCardImagePane(boolean small) {
    return new CardImagePane(this.getClass().getResource(
            getValueAsString().toLowerCase() + "_of_"
                    + getSuitAsString().toLowerCase() + ".png"), small);
}

class CardImagePane extends JLayeredPane {

    private static final long serialVersionUID = 6829613165978637891L;

    private Image image;

    public CardImagePane(URL imgURL, boolean small) {
        Image tempImg = new ImageIcon(imgURL).getImage();
        this.image = tempImg.getScaledInstance(Constants.CARD_WIDTH,
                Constants.CARD_HEIGHT, Image.SCALE_SMOOTH);

        Dimension size = new Dimension(small ? Constants.CARD_WIDTH_SMALL
                : Constants.CARD_WIDTH, Constants.CARD_HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}