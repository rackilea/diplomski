public class MouseMotionEventDemo extends JPanel implements MouseMotionListener {

private int mX, mY;
int bufferX = 0;
int bufferY = 0;
int count = 0;

public MouseMotionEventDemo() {
    addMouseMotionListener(this);
    setVisible(true);
}

public void mouseMoved(MouseEvent me) {
    mX = (int) me.getPoint().getX();
    mY = (int) me.getPoint().getY();
    bufferX += mX;
    bufferY += mY;
    System.out.println("X: "+mX+"  Y:"+mY);
    count++;
    if (count == 12) { 
        System.out.println("X average =" +bufferX / 12);
        System.out.println("Y average =" +bufferY / 12);
        count = 0;

    }
}

public void mouseDragged(MouseEvent me) {
     }

public static void main(String[] args) {
    JFrame f = new JFrame();
    f.getContentPane().add(new MouseMotionEventDemo());
    f.setSize(200, 200);
    f.show();


}