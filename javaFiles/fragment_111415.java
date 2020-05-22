@SuppressWarnings("serial")
class Jeu extends JPanel {
    private static final int JEU_W = 600;
    private static final int JEU_H = 450;

    public Jeu(int score, int plateauX, int balleX, int balleY, boolean perdu) {
        super();
        setBorder(BorderFactory.createTitledBorder("Jeu"));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();            
        } else {
            return new Dimension(JEU_W, JEU_H);
        }
    }

    public Jeu() {
        this(0, 0, 0, 0, false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // draw with g2 here
    }
}