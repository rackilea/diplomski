for (int i = 0; i < ELEMENTS; i++) {
    Image image = ImageIO.read(file[i]);
    Image imageScaled = image.getScaledInstance(80,95,Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(imageScaled);
    foodLabel[i] = new JLabel(imageIcon);
}