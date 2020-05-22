class MyCanvas extends JComponent
{
  public BufferedImage bgImg; // your background image

  @Override
  public void paintComponent(Graphics g)
  {
     super.paintComponent(g);
     g.drawImage(bgImg, x, y, this); // draw background image
  } 
  }
}