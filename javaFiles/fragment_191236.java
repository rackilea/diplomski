class DecRenderer extends DefaultTableCellRenderer implements Icon {

    private static final int SIZE = 32;
    private static final int HALF = SIZE / 2;
    DecimalFormat df;

    public DecRenderer(DecimalFormat df) {
        this.df = df;
        this.setIcon(this);
        this.setHorizontalAlignment(JLabel.RIGHT);
        this.setBackground(Color.lightGray);
    }

    @Override
    protected void setValue(Object value) {
        setText((value == null) ? "" : df.format(value));
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.blue);
        double v = Double.valueOf(this.getText());
        int d = (int)(v * SIZE);
        int r = d / 2;
        g2d.fillOval(x + HALF - r, y + HALF - r, d, d);
    }

    @Override
    public int getIconWidth() {
        return SIZE;
    }

    @Override
    public int getIconHeight() {
        return SIZE;
    }
}