public class DayRectangle extends JPanel {
    private static Color RECT_COLOR = Color.LIGHT_GRAY;
    private static final int PREF_W = 60;
    private static final int GAP = 4;
    private int posX;
    private int posY;
    private int day;

    public DayRectangle(int posX, int posY, int day) {
        this.posX = posX; // not sure that you need this
        this.posY = posY; // ditto
        this.day = day;

        // if you desire a background to show throw
        // setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(RECT_COLOR);
        g.fillRect(GAP, GAP, PREF_W - 2 * GAP, PREF_W - 2 * GAP);
    }

    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_W);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d):%d", posX, posY, day);
    }
}