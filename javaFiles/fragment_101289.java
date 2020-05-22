class Ball extends JPanel {

    private int radius = 10;
    private int x;
    private int y;
    private int dx = 3;
    private int dy = 3;

    private Timer timer = new Timer(20, new TimerListener());

    public void StartBouncingBallTest() {

        timer.start();

    }

    public void StopBouncingBallTest() {

        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 2 * radius, 2 * radius);

    }

    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (x < 0 || x + (2 * radius) > getWidth()) {
                dx *= -1;
            }
            if (y < 0 || y + (2 * radius) > getHeight()) {
                dy *= -1;
            }

            x += dx;
            y += dy;
            repaint();
        }
    }
}