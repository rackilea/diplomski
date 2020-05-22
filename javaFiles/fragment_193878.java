import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Game g = new Game();
        g.init();
        frame.getContentPane().add(g);
        frame.pack();
        frame.setVisible(true);
    }
}