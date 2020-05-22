public class MyFrame extends JFrame implements MouseMotionListener {

    ....

    public void mouseMoved(MouseEvent e){
        Point p = e.getPoint();
        int x = (int) p.getX();
        int y = (int) p.getY();

        // do something withe the x and y points
    }

    public void mouseDragged(MouseEvent e){

    }
}