public class CirclePanel extends JPanel {
    Circle circle = new Circle(100, 100);

    public CirclePanel() {
        InputMap inputMap = getInputMap(JComponent.WHEN_FOCUSED_IN_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        getActionMap().put("moveRight", new AbstractAction(){
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