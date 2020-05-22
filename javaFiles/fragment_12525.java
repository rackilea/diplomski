JPanel panel = new JPanel()
{
    @Override
    public boolean isOpaque()
    {
        return false;
    }

    @Override
    public boolean contains(Point p)
    {
        // Use something that fits your shape here.
        return p.getX() % 2 == 0;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        // do some painting
    }
};