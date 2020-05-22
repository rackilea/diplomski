Point p1 = new Point(100, 100);
Point p2 = new Point(300, 100);
Point p3 = new Point(110, 100);
Point p5 = new Point(310, 100);
Point p4 = new Point(90, 100);
static JFrame start = new JFrame("Start");

if(p3.x >= start.getWidth()-90)
{
    p3.x = start.getWidth()-70;
    p3.x = (int) (p1.getX()+10);
    p3.setLocation(p3.x, p3.y);
}

if(key == KeyEvent.VK_S && !paintingFBR && !paused)
{
    p1.y++;
    p3.y++;
    test1.setLocation(p1);
    test3.setLocation(p3);
}