public class Animation extends JFrame implements ActionListener {
    private Timer timer;
    private RectanglePanel panel;

    public Animation() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(panel = new RectanglePanel());

        timer = new Timer(100, this); //every 100 ms add new Shape

        JButton button = new JButton("Start Animation");
        button.addActionListener(e -> timer.start()); //start animation timer
        add(button, BorderLayout.PAGE_END);
        pack();
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.createNewShape(); //add new shape
        panel.repaint();
    }

    private class RectanglePanel extends JPanel {
        private List<Rectangle> shapes;

        public RectanglePanel() {
            super();
            this.shapes = new ArrayList<>();
        }

        public void createNewShape() {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            x = Math.min(x, getWidth() - 10);
            y = Math.min(y, getHeight() - 10);
            Rectangle r = new Rectangle(x, y, 10, 10);
            System.out.println("New rectangle:" + r);
            shapes.add(r);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Rectangle r : shapes) {
                g.setColor(randomColor());
                g.drawRect(r.x, r.y, r.width, r.height);
            }
        }

        private Color randomColor() {
            return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        }
    }

    public static void main(String[] args) {
        //All swing applications must run on their own thread
        SwingUtilities.invokeLater(() -> new Animation().setVisible(true));
    }
}