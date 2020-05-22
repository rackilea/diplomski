public class GraphicsFrame extends JFrame {

    Image image;

    //introduce constructor
    public GraphicsFrame() {

        setupframe();
    }

    void setupframe() {

        // no need to create a frame. This class is a JFrame
        //JFrame frame = new JFrame(); // create the frame
        setSize(500,500);
        setLayout(new BorderLayout());
        setResizable(false);

        setTitle("Zuul the ultimate fridaybar game"); // sets title in top bar of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what will happens when the frame close (exit)

        //initialize image
        image = new ImageIcon("src/Image/Kort.png").getImage();

        setContentPane(new DrawPane());

        setVisible(true); // show the frame
    }

    class DrawPane extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            //add draw image to paint
            g.drawImage(image,0, 0, null);

            //this draws a circle
            g.setColor(Color.red);
            g.drawOval(100, 100, 40, 40);
        }
    }

    public static void main(String args[]) {

        new GraphicsFrame();
    }
}