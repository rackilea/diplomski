public class Select  extends JFrame{
private ArrayList<ArrayList<Point>> Strokes = new ArrayList<>();
private ArrayList<Color> color = new ArrayList<Color>();
private JButton b;
private Color rangi = (Color.WHITE);
private JPanel panel;
public Select () {
    super ("Color Selection");
    panel = new JPanel();
    panel.setBackground(Color.WHITE);
    b= new JButton ("Choose Colour");
    b.addActionListener(
    new ActionListener(){          
        public void actionPerformed (ActionEvent event)
        {                
            //rangi = 
            rangi = (JColorChooser.showDialog(null, "Pick your colour", rangi));
            Graphics g = getGraphics();
            if (rangi == null)
                rangi=(Color.WHITE);

        }                    
    }
    );
    addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
              ArrayList<Point> lastPoint = new ArrayList();
            lastPoint.add(new Point(e.getX(), e.getY()));
             Strokes.add(lastPoint);
             color.add(rangi);

        }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
            Graphics g = getGraphics();
            int last = Strokes.size();
            int lastp = Strokes.get(last-1).size();
            Strokes.get(last-1).add(new Point(e.getX(), e.getY()));
             g.setColor(rangi);

           g.drawLine( Strokes.get(last-1).get(lastp - 1).x,  Strokes.get(last-1).get(lastp -1).y,e.getX(), e.getY());              
            g.dispose();

        }
    });
    add(panel, BorderLayout.CENTER);
    add(b, BorderLayout.SOUTH);
    setSize(600, 600);
    setVisible(true);
}
@Override
public void paint(Graphics g){
    super.paint(g);

     for (int y = 0; y < Strokes.size(); y++) {
    int i = 0;
    g.setColor(color.get(y));
    for (int j = 1; j < Strokes.get(y).size(); j++) {

            g.drawLine(Strokes.get(y).get(i).x, Strokes.get(y).get(i).y,
                    Strokes.get(y).get(j).x, Strokes.get(y).get(j).y);
            i++;
    }
}
}

public static void main(String [] args)
{
    Select s = new Select();
    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}