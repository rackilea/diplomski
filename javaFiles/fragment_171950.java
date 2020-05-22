import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
public class MyCurveApplet extends JApplet{
     private static Marker selectedMarker;
    @Override
    public void init(){
        this.add(pane);
        pane.addMouseListener(new MouseHandler());
        pane.addMouseMotionListener(new MouseHandler());
    }
    private class CurvePane extends JComponent{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D)g;
            if(a!=null&&b!=null&&ctrl!=null){
                System.out.println("Repainted!");
                String text;
                aMark = new Marker(a,"a");
                bMark = new Marker(b,"b");
                ctrlMark = new Marker(ctrl,"ctrl");
                quadCurve = new QuadCurve2D.Double(a.x, a.y, ctrl.x, ctrl.y, b.x, b.y);

                aMark.draw(g);
                g2D.setPaint(Color.BLACK);
                text = "A"+"\n"+"("+a.x+","+a.y+")";
                g2D.drawString(text,(int)a.x,(int)a.y+30);
                bMark.draw(g);
                g2D.setPaint(Color.BLACK);
                text = "B"+"\n"+"("+b.x+","+b.y+")";
                g2D.drawString(text,(int)b.x,(int)b.y+30);
                ctrlMark.draw(g);
                g2D.setPaint(Color.BLACK);
                text = "Control"+"\n"+"("+ctrl.x+","+ctrl.y+")";
                g2D.drawString(text,(int)ctrl.x,(int)ctrl.y+30);

                g2D.setPaint(Color.BLACK);
                g2D.draw(quadCurve);
            }
        }
    }
    private class MouseHandler extends java.awt.event.MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){

            if(a==null||b==null||ctrl==null){
                System.out.println("FOO");
                if(a==null){
                    a = new Point2D.Double(e.getX(), e.getY());
                }else if(b==null){
                    b = new Point2D.Double(e.getX(), e.getY());
                }else{
                    ctrl = new Point2D.Double(e.getX(), e.getY());
                }
            }else if(aMark!=null&&bMark!=null&&ctrlMark!=null){
                if(aMark.contains(e.getX(),e.getY())){
                    System.out.println("SelecteMarker A");
                    selectedMarker = aMark;
                }else if(bMark.contains(e.getX(),e.getY())){
                    System.out.println("SelecteMarker B");
                    selectedMarker = bMark;
                }else if(ctrlMark.contains(e.getX(),e.getY())){
                    System.out.println("SelecteMarker CTRL");
                    selectedMarker = ctrlMark;
                }
            }
        }
        @Override
        public void mouseDragged(MouseEvent e){
            if(selectedMarker!=null){
                if (0 == selectedMarker.name.compareTo("a")){
                    a.x = e.getX();
                    a.y = e.getY(); 
                }else if (0 == selectedMarker.name.compareTo("b")){
                    b.x = e.getX();
                    b.y = e.getY();
                }else if (0 == selectedMarker.name.compareTo("ctrl")){
                    ctrl.x = e.getX();
                    ctrl.y = e.getY();

                }

                pane.repaint();
            }
        }
        @Override
        public void mouseReleased(MouseEvent e){
            System.out.println("SelectedMark NULL");
            selectedMarker = null;
            pane.repaint();
        }

    }
    private class Marker{
        public String name;
        public Marker(Point2D.Double center, String name){
            this.name = name;
            this.center.setLocation(center);
            circle = new Ellipse2D.Double(center.x,center.y,r,r);
        }
        public void draw(Graphics g){
            Graphics2D g2D = (Graphics2D)g;
            if(circle!=null){
                g2D.setPaint(selectedColor);
                g2D.draw(circle);
            }
        }
        public boolean contains(int x,int y){
            return circle.contains(x, y);
        }
        public void setLocation(int x,int y){
            center.x = x;
            center.y = y;
            circle = new Ellipse2D.Double(center.x,center.y,r,r);
        }
        public Point2D.Double center = new Point2D.Double();
        private Ellipse2D.Double circle;
        private static final double r = 6;
    }

    private Point2D.Double a;
    private Point2D.Double b;
    private Point2D.Double ctrl;
    private QuadCurve2D.Double quadCurve;
    Marker aMark;
    Marker bMark;
    Marker ctrlMark;
    private Color selectedColor = Color.orange;
    private CurvePane pane = new CurvePane();
}