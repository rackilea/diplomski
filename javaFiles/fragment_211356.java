JPanel glassPane = new JPanel() {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0, 100, 0, 100));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
};
glassPane.setOpaque(false);

frame.setGlassPane(glassPane);
frame.getGlassPane().setVisible(true);