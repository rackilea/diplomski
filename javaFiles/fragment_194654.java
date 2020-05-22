public class Dynamic_JFrame extends JPanel {

static JFrame frame;
// Not sure that this is a good idea...
Graphics g;

//...

public Dynamic_JFrame(){

    // Don't use this...
    //frame.setVisible(true);

}

public static void main(String[] args){
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            Dynamic_JFrame d = new Dynamic_JFrame();
            frame = new JFrame("Changing colors");
            frame.setLayout(new FlowLayout());
            frame.add(d);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    });
}