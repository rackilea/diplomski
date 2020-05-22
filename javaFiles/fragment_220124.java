@Override
protected void paintComponent(Graphics g)
{
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g.create();

    //  do custom painting

    g2d.dispose();
}