import java.applet.Applet;
import java.awt.*;
import java.net.*;
public class BGTest extends Applet
{
    Label testLabel;
    Image bgImage = null; 

    public void init()
    {
        try 
        { 
            MediaTracker tracker = new MediaTracker (this);
            bgImage = getImage
            (new URL("download.jpg")); 
            tracker.addImage(bgImage, 0);
        } catch (Exception e) { System.out.println(e.toString());}      
        testLabel=new Label("Testing");
        add(testLabel);     
    }

    public void paint(Graphics g) 
    {   
        super.paint(g);
        g.drawImage(bgImage,0,0,this); 
    }
}