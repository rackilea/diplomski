public static class SoftButton extends Button 
{
    private Image image;

    public SoftButton() 
    {            
        setLabel("test");
        setBackground(Color.red);
        // Load the icon once in the constructor:
        image = Toolkit.getDefaultToolkit().getImage("/tmp/world.gif");
    }

    public void paint(Graphics g) 
    {  
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

}