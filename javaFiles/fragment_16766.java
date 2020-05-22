public class Welcome {

    static GUI run = new GUI ();


    public static void main (String [] args) {


        run.setPreferredSize(new Dimension(800, 500));
        run.setResizable(false);
        run.setVisible(true);
        run.setLocation(250,150);
        run.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        ImageIcon img = new ImageIcon("C:/Users/hp/documents/MyLogo.png");
        run.setIconImage(img.getImage());
        run.setTitle( "Pearl Math-Whiz");
        run.pack();



    }