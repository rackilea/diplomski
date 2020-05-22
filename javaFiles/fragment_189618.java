public class Overlay extends JFrame {
    private Point start = new Point();
    private Point end = new Point();

    public Overlay() {
        OverlayMouseAdapter listener = new OverlayMouseAdapter();
        addMouseMotionListener(listener);
        addMouseListener(listener);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setAlwaysOnTop(true);
        setUndecorated(true);
        setBackground(new Color(255, 255, 255, 180));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR,
                    0.1f));
        g2d.setColor(new Color(0, 0, 0, 255));
        g2d.fillRect(start.x, start.y, end.x -start.x, end.y-start.y);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
        g2d.setColor(Color.BLACK);
        g2d.drawRect(start.x-1, start.y-1, end.x -start.x + 1, end.y-start.y+1);
    }

    private class OverlayMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            start = e.getLocationOnScreen();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            end = e.getLocationOnScreen();
            repaint();
        }
    }
}