public class Model1 extends JComponent {
    //private int xPos, yPos;

    Model1 (int x, int y){
        //this.xPos = x;
        //this.yPos = y;
        setLocation(x, y);
        setSize( getPreferredSize() );
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(5, 5);
    }
    @Override
    protected void paintComponent(Graphics g) {     
        g.setColor(Color.BLACK);
        //g.drawOval(xPos, yPos, 5, 5);                   
        g.drawOval(0, 0, 5, 5);                   
    }
}