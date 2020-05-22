enum Token {

    VIDE (Color.WHITE), CERCLE_BLEU (Color.BLUE), CERCLE_ROUGE(Color.RED);

    private static final int ICON_W = 21;
    public Color color;
    public Icon icon;

    Token(Color color) {

        this.color = color;
        icon = createIcon(color);
    }

    private Icon createIcon(Color color) {

        BufferedImage img = new BufferedImage(ICON_W, ICON_W, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(color);
        g2.fillOval(1, 1, ICON_W - 2, ICON_W - 2);
        g2.dispose();

        return new ImageIcon(img);
    }
}