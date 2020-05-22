package temp;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new NewJPanel());
                f.pack();
                f.setVisible(true);
            }
        });
    }
}