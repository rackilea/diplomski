public class MyFrame extends JFrame implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        int x = (int) p.getX();
        int y = (int) p.getY();

        // do something withe the x and y points
    }
}