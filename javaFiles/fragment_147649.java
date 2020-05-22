public class WelcomeWindow extends JFrame {

    private ToolPanel top = new ToolPanel("/guiresources/BgTop.png");
    private PaperPanel middle = new PaperPanel("/guiresources/BgPaper.png");
    private ToolPanel bottom = new ToolPanel("/guiresources/BgBottom.png");

    public WelcomeWindow() throws IOException {
        initComponents();
    }

    private void initComponents() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        middle.setPreferredSize(new Dimension(640, 480));
        this.add(top, BorderLayout.NORTH);
        this.add(middle, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);

        MouseHandler mouseHandler = new MouseHandler();
        top.addMouseListener(mouseHandler);
        top.addMouseMotionListener(mouseHandler);
        bottom.addMouseListener(mouseHandler);
        bottom.addMouseMotionListener(mouseHandler);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private class MouseHandler extends MouseAdapter {

        private Point point = new Point();

        @Override
        public void mousePressed(MouseEvent e) {
            point.x = e.getX();
            point.y = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point p = getLocation();
            setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
        }
    }
}

class PaperPanel extends JPanel {

    protected Image image;

    PaperPanel(String name) {
        try {
            image = ImageIO.read(getClass().getResource(name));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}

class ToolPanel extends PaperPanel {

    ToolPanel(String name) {
        super(name);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(null), image.getHeight(null));
    }
}