public class FrogPane extends JPanel {

    private Timer timer;
    int x = 0, velX = 2;

    public FrogPane() {
        timer = new Timer(40, new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            x = x + velX;
                                            repaint();
                                        }
                                    });
        setBackground(Color.CYAN);
    }

    public void start() {
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);
        g2d.drawRect(100, 10, 30, 40);
        g2d.fillRect(x, 10, 20, 10);
        g2d.dispose();
    }

}