public class Components extends JPanel implements ActionListener
{
    //....
    @Overrride
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(em.equals("Rectangle"))
        {
            g.drawRect(50, 50, 50, 50);
        }
        else if(em.equals("Circle"))
        {
            g.drawOval(50, 50, 50, 50);
        }    
    }