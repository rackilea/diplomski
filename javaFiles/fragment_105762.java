class CardUI extends JComponent {
    //... class members ...

    public CardUI(BufferedImage cardPhoto){
        this.cardPhoto= cardPhoto;
    }

    void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cardPhoto, x, y, this);
    }
}