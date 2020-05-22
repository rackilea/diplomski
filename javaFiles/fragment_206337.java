private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

...

@Override
protected void paintComponent(Graphics g)
{
    super.paintComponent(g);

    for (Rectangle r: rectangles)
    {
        g.setColor( Color.RED );
        g.drawRect(...);
    }
}

public void addRectangle(Rectangle r)
{
    rectangles.add( r );
}