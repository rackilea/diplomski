public class CirclePanel extends JPanel {
    Circle circle = new Circle(100, 100);

    public CirclePanel() {
        JButton button = new JButton("Move Right");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                circle.x += 10;
                repaint();
            } 
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       circle.drawCircle(g);
    }
}