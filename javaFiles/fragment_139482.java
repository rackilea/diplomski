for (int i = 0; i < ELEMENTS; i++) {
    image[i] = ImageIO.read(file[i]);
    imageScaled[i] = image[i].getScaledInstance(80,95,Image.SCALE_SMOOTH);
    imageIcon[i] = new ImageIcon(imageScaled[i]);
    foodLabel[i] = new JLabel(imageIcon[i]);
}