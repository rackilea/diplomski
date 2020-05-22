import javax.swing.JFrame;


public class QuiltMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("QuiltPattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new QuiltPanel());
        frame.getContentPane().add(new QuiltPanel());

        frame.pack();
        frame.setVisible(true);
    }
}