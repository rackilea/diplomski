import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/5207425 */
public class NewJavaGUI extends JPanel {

    private void display() {
        JFrame f = new JFrame("NewJavaGUI");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new NewJavaGUI().display();
            }
        });
    }
}