import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/a/14075990/230513 */
public class LayoutTest {

    private void display() {
        JFrame f = new JFrame("LayoutTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JPanel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 150); // content placeholder
            }
        }, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(); // default: FlowLayout, centered
        buttonPanel.add(new JButton("Button1"));
        buttonPanel.add(new JButton("Button2"));
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new LayoutTest().display();
            }
        });
    }
}