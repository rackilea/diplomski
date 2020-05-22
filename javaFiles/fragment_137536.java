public class Draw 
{
    public class Graphics extends JPanel
    {
        public void paintComponent(java.awt.Graphics g)
        { 
            super.paintComponent(g);
            g.setColor(Color.GRAY);
            g.drawRect(0, 0, 500, 500);
        }
    }
}