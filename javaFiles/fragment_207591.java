public class ImageTest extends JPanel implements ImageObserver {

@Override
public boolean imageUpdate(Image img, int infoflags, int x, int y,
        int width, int height) {
    if((infoflags & ALLBITS) == 0) {
        System.out.println("Processing still");
        return true;
    } else {
        System.out.println("Done processing");
        repaint();
        return false;
    }
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 0, 0, this);
}

Image img;

public ImageTest (){
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    img =  toolkit.getImage("res/soccer-ball.jpg");
    toolkit.prepareImage(img, -1, -1, this);
}

public static void main(String args[]) {
    JFrame f = new JFrame();
    f.setContentPane(new ImageTest());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(1000, 1000);
    f.setVisible(true);
}
}