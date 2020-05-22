class MyPanel2 extends JPanel {
    private static final int PREF_W = 200;
    private static final int PREF_H = PREF_W;
    private static final int GR = 240;
    public static final Color BASE_COLOR = new Color(GR, GR, GR);
    public static final Color DISABLED_COLOR = Color.CYAN;
    public static final Color SELECTED_COLOR = Color.BLACK;
    private Checkers2 checkers;
    private boolean selected = false;

    public MyPanel2(Checkers2 checkers) {
        setBackground(BASE_COLOR);
        this.checkers = checkers;
        setPreferredSize(new Dimension(PREF_W, PREF_H));
        addMouseListener(new MyMouse());
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void reset() {
        setBackground(BASE_COLOR);
        setSelected(false);
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (selected) {
                return;
            }
            if (checkers.isPanelDisabled()) {
                setBackground(DISABLED_COLOR);
            } else {
                setBackground(SELECTED_COLOR);
                setSelected(true);
            }
        }
    }
}