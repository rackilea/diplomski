public void drawImage(BufferedImage image)
    {
        JLabel label = new JLabel(new ImageIcon(image));
        label.setLocation(1, 1);
        label.setSize(50, 130);
        this.jPanel1.add(label);
        this.jPanel1.validate();
        this.jPanel1.repaint();
}