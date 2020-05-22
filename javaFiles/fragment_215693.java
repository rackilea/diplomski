public class ShapeDemo
{
    public static final int WIDTH = 300 ;
    public static final int HEIGHT = 400 ;

    public static void main(String[] args)
    {
     ArrayList<Shape> shapes = new ArrayList<Shape>() ;
     Random random = new Random() ;
     int x, y ;
     // create the ten shapes and put them in shapes array list below.

     for (int i=1; i<=10;i++) {
         x = random.nextInt(100);// random number in range of 0-99. Can be changed if needed to suit
         y = random.nextInt(100);
         shapes.add( new Ellipse.Double(x,y,WIDTH,HEIGHT));
     }
     JComponent component = new ShapeComponent2(shapes) ;
     JFrame frame = new JFrame("") ;
     frame.add(component) ;
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     frame.setSize(WIDTH, HEIGHT) ;
     frame.setVisible(true) ;
    }
}