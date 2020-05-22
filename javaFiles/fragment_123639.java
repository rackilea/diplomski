import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ExampleFrame extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExampleFrame frame = new ExampleFrame();
                frame.createAndShow();
            }
        });
    }

    public void createAndShow() {
        getContentPane().add(new HelloComponent());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hello World Example");
        pack();
        setVisible(true);
    }

}