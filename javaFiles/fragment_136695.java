import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

/**
 * @see https://stackoverflow.com/a/24275262/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new PopUpPanel("Test popup panel"));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class PopUpPanel extends JPanel {

        public PopUpPanel(final String info) {
            final JTextArea textArea = new JTextArea(info);
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createTitledBorder("Test"));
            add(textArea);
            MouseInputAdapter mouseHandler = new MouseInputAdapter() {

                @Override
                public void mouseEntered(final MouseEvent e) {
                    System.out.println(e);
                }

                @Override
                public void mouseExited(final MouseEvent e) {
                    System.out.println(e);
                }
            };
            addMouseListener(mouseHandler);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}