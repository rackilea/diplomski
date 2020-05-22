@Override
public void paintComponent(Graphics g){
    Dimension size = this.getSize();
    g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\User\\Downloads\\MainMenu.jpg"), 0, 0, size.width, size.height, this);
    FontMetrics fm = g.getFontMetrics();
    int x = (getWidth() - fm.stringWidth("String Value To Set")) / 2;
    int y = ( (getHeight() - fm.getHeight() ) / 2) + fm.getAscent() ;
    g.drawString(String Value To Set, x, y);
}