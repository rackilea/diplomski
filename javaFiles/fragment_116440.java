public class TablePanel extends JPanel {
    List<Ball> balls = new ArrayList<Ball>();

    public TablePanel(){
        makeBalls();
    }

    public void makeBalls(){
        balls.add(new Ball(213, 2, 255, true);
        // add more balls
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Ball ball : balls) {
            ball.drawBall(g);
        }
    }
}