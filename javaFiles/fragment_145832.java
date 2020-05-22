private Image rotate(double degs){
    ImageIcon img = new ImageIcon("src/inc/img/char_male.png"); // why an ImageIcon???
    Image temp = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = (Graphics2D) temp.getGraphics();
    g2.rotate(Math.toRadians(degs), img.getIconWidth()/2, img.getIconHeight()/2); // changed
    g2.drawImage(img.getImage(), 0, 0, Color.WHITE, null);
    System.out.println("Rotating "+degs);
    g2.dispose();
    return temp;
}