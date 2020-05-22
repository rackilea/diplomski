public void paintComponent(Graphics g)
{

    super.paintComponent(g);

    g.setColor(new Color(230, 100, 100));
    g.fillRect(0, 0, 200, 100);
    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

}