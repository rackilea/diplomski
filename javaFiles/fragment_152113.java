public class Painter extends JPanel{

    public Painter(){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(20, 80, 20, 200);
        g.drawLine(20, 200, 140, 200);
        g.drawLine(x1, y1, x2, y2);
    }
}

...
JFrame frame = new JFrame("Title");
frame.add(new Painter());