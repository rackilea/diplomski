@Override
    public void paint(Graphics g)
    {    
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g.create();
        myCloud.draw(g2d);
        g2d.dispose();
    }