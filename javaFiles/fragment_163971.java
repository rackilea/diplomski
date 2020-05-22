import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();

            JButton j1 = new JButton("Button 1");
            JButton j2 = new JButton("Button 22222222222222");
            JButton j3 = new JButton("Button 333333");
            JButton j4 = new JButton("4");

            gc.insets = new Insets(5, 10, 5, 10);
            gc.ipady = 50;
            gc.gridwidth = GridBagConstraints.REMAINDER;
            gc.fill = GridBagConstraints.BOTH;
            add(j1, gc);
            add(j2, gc);
            add(j3, gc);
            add(j4, gc);
        }

    }
}