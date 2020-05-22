ImageIcon icon = new ImageIcon("C:\\Users\\Dark Mangetsu\\Downloads\\Ceng102_Lab10.1\\image\\flower.jpg");
Image image = icon.getImage();
JPanel panel1 = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight());
    }
};