public class OverlayBorderJPanel extends JPanel
{
    boolean containsMouse = false; //set to true by mouseListener when contains
    BufferedImage overlay = //you would need to load an image border here, 
                            //rather than having a java created border
                            //You could have alpha so it is half see-through

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (containsMouse)
        {
            g.drawImage(//use 0,0 position with panel width/height)
        }
    }
}