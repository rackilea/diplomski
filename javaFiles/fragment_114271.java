public class Display {
    public JFrame frame; 

    public static void main(String[] args) {
        Display display = new Display();
        display.frame = new JFrame();
        display.frame.setSize(800, 600);
        display.frame.setVisible(true);
    }
 }