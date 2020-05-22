public void render(Graphics g)
{
    Graphics2D g2d = (Graphics2D)g.create();
    g2d.rotate(Math.toRadians(degrees), xPos+16, yPos+16);
    g2d.drawImage(player, xPos, yPos, null);
    g2d.dispose();
}