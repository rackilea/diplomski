// That is, something like this - 
public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
}