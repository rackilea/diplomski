public void paintComponent(Graphics g)
{
  super.paintComponent(g);
  if(image != null)
    g.drawImage(image, 0, 0, this);
}