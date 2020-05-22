public class CordsTest extends Applet implements ActionListener{

    private Cords cords;

    public void paint(Graphics g){
        w=getWidth();
        h=getHeight();
        g.setColor(Color.black);
        if (cords == null) {
            cords = new Cords();
        }
        cords.paint(g, w, h, 10);
    }