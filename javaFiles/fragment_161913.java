class Grid extends JPanel {
    private static final long serialVersionUID = 1L;
    private int prefW;
    private int prefH;


    public Grid(int prefW, int prefH) {
        this.prefW = prefW;
        this.prefH = prefH;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(0,128,0));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }

}