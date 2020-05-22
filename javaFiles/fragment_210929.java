class GridPanel extends JPanel {

    public static final int HEIGHT = 50;
    public static final int WIDTH = 50;
    private boolean filled;
    private int numberGridsFilled = 0;
    private int row, col;

    public GridPanel(int row, int col) {
        row = row;
        col = col;
        filled = false;
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.red);
    }

    public Dimension getPreferredSize() {
        return new Dimenions(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setPaint(Color.GRAY);
        Rectangle2D r = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
        g2d.draw(r);
        g2d.dispose();
    }