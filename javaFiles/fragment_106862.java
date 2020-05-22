public class Grid extends JFrame {
    private static final int SCALE = 10; // 1 boolean value == 10 x 10 pixels.
    private static final int SIZE = 20;

    private boolean[][] matrix = new boolean[SIZE][SIZE];
    private boolean painting;
    private int lastX = -1;
    private int lastY = -1;

    public Grid() throws HeadlessException {
        setPreferredSize(new Dimension(SIZE * SCALE, SIZE * SCALE));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                painting = true;
                tryAdjustValue(e.getPoint());
            }

            public void mouseReleased(MouseEvent e) {
                painting = false;
                lastX = -1;
                lastY = -1;
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                tryAdjustValue(e.getPoint());
            }

            public void mouseMoved(MouseEvent e) {
                tryAdjustValue(e.getPoint());
            }
        });
    }

    private void tryAdjustValue(Point pt) {
        int newX = pt.x / SCALE;
        int newY = pt.y / SCALE;

        if (painting && isInRange(newX) && isInRange(newY) && (newX != lastX || newY != lastY)) {
            // Only invert "pixel" if we're currently in painting mode, both array indices are valid
            // and we're not attempting to adjust the same "pixel" as before (important for drag operations).
            matrix[newX][newY] = !matrix[newX][newY];
            lastX = newX;
            lastY = newY;
            repaint();
        }
    }

    private boolean isInRange(int val) {
        return val >= 0 && val < SIZE;
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int x=0; x<SIZE; ++x) {
            for (int y=0; y<SIZE; ++y) {
                if (matrix[x][y]) {
                    g.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
                }
            }
        }
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.pack();
        grid.setLocationRelativeTo(null);
        grid.createBufferStrategy(2);
        grid.setVisible(true);
    }
}