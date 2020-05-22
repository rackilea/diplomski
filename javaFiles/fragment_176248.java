import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.applet.*;
public class DisplayImage extends Applet implements KeyListener{

 int coordX=0;//ship x axis position
 int coordY=0;//ship y axis position
 /*
  0-------------------------x
 0|
  |
  |
  |
  |
  |
  y
 */
public URL getURL(String filename)
{
    URL url = null;
    try
    {
        url = this.getClass().getResource(filename);
    }
    catch(Exception e){e.printStackTrace();}
    return url;
}
private Image image;
public void init()
{
    image = getImage(getURL("spaceship.png"));
    addKeyListener(this);
}
public void update(){repaint();}//let update control the calls to repaint
public void paint(Graphics g)
{

    Graphics2D g2d = (Graphics2D)g;
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0,0,getSize().width,getSize().height);

    g2d.drawImage(image,coordX,coordY,this);//paint the spaceship to the updated coordinates
}
public void keyPressed(KeyEvent e)
{
    int keycode = e.getKeyCode();
    //37=left arrow. 39=right arrow. 38=up & 40=down
    if(keycode==37){coordX-=1;}else if(keycode==39){coordX+=1;}
    if(keycode==38){coordY-=1;}else if(keycode==40){coordY+=1;}

update();//request repaint when logic has updated
}
public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e){}

}