import java.awt.*;
import java.applet.Applet;

public class DrawPoly extends Applet {

    Polygon poly;

    // init(Graphics) is not an applet method
    //public void init(Graphics g){
    @Override
    public void init() {
        // this declaration is creating a variable local
        // to the init() method
        //Polygon poly=new Polygon();
        poly=new Polygon();
        poly.addPoint(60,100);
        // at least add a 2nd point!
        poly.addPoint(160,60);
    }

    public void paint(Graphics g) {
        Graphics2D gg;
        gg=(Graphics2D) g;
        System.out.println("number is"+ poly.npoints);
        // the Polygon is never painted!
        gg.setColor(Color.BLACK);
        gg.drawPolygon(poly);
    }
}