public void paint(Graphics g)
{
    int incX = 5;   // initial x increment for circle locations
    int incY = 5;   // initial y increment for circle locations

    Coord temp = new Coord(0,0);
    Queue<Coord> q = new LinkedList<Coord>();

    Circle c = new Circle(g,circleSize,incX,incY,TIME_DELAY);
    try
    {
        for(int i = 1; i <= TOTAL_NUM_CIRCLES; i++)
        {
            if(q.size() >= 50)
            {
                temp = q.remove();
                c.eraseCircle(g,temp.getX(),temp.getY());
            }
            temp = new Coord(getX(),getY());
            //q.add(temp);
            q.add(c.drawCircle(g));
            c.hitEdge();
        }
    }
    catch(InterruptedException e){}
}