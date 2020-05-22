public class PuzzelPane extends JPanel {

    private List<Piece> pieces;

    public PuzzelPane() {
        Dimension size = getPreferredSize();
        pieces = new ArrayList<>(25);
        Point location = new Point((size.width - 50) / 2, (size.width - 50) / 2);
        pieces.add(new Square(location, 50, Color.BLUE));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Piece piece : pieces) {
            Graphics2D g2d = (Graphics2D) g.create();
            piece.paint(g2d);
            g2d.dispose();
        }
    }

}