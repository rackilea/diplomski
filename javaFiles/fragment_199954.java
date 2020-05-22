//LongTab.java
 //Desktop Tab

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import java.awt.geom.*;
    import com.sun.awt.AWTUtilities.*;

    public class LongTab extends JWindow implements MouseListener{

    static LongTab t;
    Boolean isVisible = false;

    GeneralPath closed;

    final static BasicStroke stroke = new BasicStroke(2.0f);
    GeneralPath path;


    //Constructor
    public LongTab(){


        addMouseListener(this);
        setSize(500, 1080);


    addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent e){
    Polygon polygon = new Polygon();
    polygon = new Polygon();

    polygon.addPoint(40, 1080);
    polygon.addPoint(40, 700);

    polygon.addPoint(20, 690);
    polygon.addPoint(20, 400);
    polygon.addPoint(40, 390);

    polygon.addPoint(40, 0);
    polygon.addPoint(500, 0);
    polygon.addPoint(500, 1080);



    path = new GeneralPath();
    path.append(polygon, true);
    //setShape(path);
    com.sun.awt.AWTUtilities.setWindowShape(t, path);

    }});

    setSize(40, 1080);
    setLocation(1880, 0);

    }//end of constructor.

     public void mouseClicked (MouseEvent me) {


      if(!isVisible){
      isVisible=true;
      t.setSize(400, 1080);
      t.setLocation(1520, 0);

    return;
    }
      if(isVisible){
      isVisible=false;
      t.setSize(40, 1080);
      t.setLocation(1880, 0);
      }
      return;

    }
     public void mouseEntered (MouseEvent me) {}
     public void mousePressed (MouseEvent me) {}
     public void mouseReleased (MouseEvent me) {} 
     public void mouseExited (MouseEvent me) {}  

     public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //antialias commented out to fix outline glitch.
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setStroke(stroke);

    g2.drawLine(40, 1080, 40, 700);
    g2.drawLine(40, 700, 20, 690);
    g2.drawLine(20, 690, 20, 400);
    g2.drawLine(20, 400, 40,390);
    g2.drawLine(40, 390, 40, 0);



    }
    public static void main (String[] args){

                t = new LongTab();
                t.setVisible(true);
    }

}