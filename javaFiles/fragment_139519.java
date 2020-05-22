public void paint(Graphics g)
{
    //g = getComponentGraphics(g);
    super.paint(g);  // use the Graphics object passed to the method

    //paint my custom content

    g.drawRect(10, 10, 20, 20);
}