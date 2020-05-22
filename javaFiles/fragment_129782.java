@SuppressWarnings("serial")
class MyPanel3 extends JPanel {
    private static final int PREF_W = 200;
    private static final int PREF_H = PREF_W;
    private static final int GR = 240;
    public static final Color BASE_COLOR = new Color(GR, GR, GR);
    public static final Color DISABLED_COLOR = Color.CYAN;
    public static final Color SELECTED_COLOR = Color.BLACK;
    private boolean selected = false;

    public MyPanel3() {
        setBackground(BASE_COLOR);
        setPreferredSize(new Dimension(PREF_W, PREF_H));
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        Color background = selected ? SELECTED_COLOR : DISABLED_COLOR;
        setBackground(background);
    }

    public boolean isSelected() {
        return selected;
    }

    public void reset() {
        setSelected(false);
        setBackground(BASE_COLOR);
    }
}