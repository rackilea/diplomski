public class CirclePanel extends JPanel {
    Circle circle = new Circle(100, 100);

    public CirclePanel() {
        Timer timer = new Timer(50, new ActionListener(){
            @Override
            public void actionPerfomed(ActionEvent e) {
                circle.x += 10;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       circle.drawCircle(g);
    }
}