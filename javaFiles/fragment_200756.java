@Override
public void paint(Graphics g)
{
    if (image != null)
    {
        g.drawImage(image, 0, 0, (int) getSize().getWidth() - 0, (int) getSize().getHeight() - 0, this);
    }
    super.paint(g);
}