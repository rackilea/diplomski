JPanel panel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(), image.getHeight());
    }
};