public class BallPanel extends JPanel {
    List<Ball> balls;

    public BallPanel() {
        Timer timer = new Timer(40, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (Ball ball : balls) {
                    ball.animate();
                }
                repaint();
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : ball ) {
            ball.draw(g);
        }
    }

    public void addBall(...) {
        balls.add(new Ball(..));
    }
}