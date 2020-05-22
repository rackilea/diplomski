class GameBoard extends JComponent {
    Random rnd = new Random();
    public ArrayList<Ball> balls = new ArrayList<Ball>();
    int width = Board.boardWidth;
    int height = Board.boardHeight;

    public GameBoard() {
        for (int i = 0; i < 50; i++) {
            int randomStartXPos = (int) (Math.random() * (Board.boardWidth - 40) + 1);
            int randomStartYPos = (int) (Math.random() * (Board.boardHeight - 40) + 1);
            balls.add(new Ball(randomStartXPos, randomStartYPos, 30));
        }
    }

    public void move() {
        for (Ball ball : balls) {
            ball.move();
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
        for (Ball ball : balls) {
            // ball.move();
            g2d.draw(ball.getEllipse());
        }
    }
}