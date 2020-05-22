JPanel panel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        // drawing code using g
    }
};
JFrame frame = new JFrame();
frame.setContentPane(panel);
frame.setSize(600, 600);
frame.setLocation(200,300);
frame.setVisible(true);