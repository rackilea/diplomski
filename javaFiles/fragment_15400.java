@Override
public void paint(Graphics g)
{
   // ********** no super call here! *******
   g.setColor(color);
   g.fillOval(x, y, 4, 4);
}