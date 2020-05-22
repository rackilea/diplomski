BufferedImage img = ImageIO.read(new File("test.png"));
JComponent component = new JComponent() {
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(img, 0, 0, null);
    };
};
component.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        shiftToBlack(img);
        component.repaint();
    }
});
JFrame frame = new JFrame("test");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(component);
frame.pack();
frame.setSize(150, 150);
frame.setVisible(true);