import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

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
            DefaultTableModel model = new DefaultTableModel(0, 1);
            model.addRow(new String[]{
                "<html>My teacher took my iPod.<br>She said they had a rule;<br>I couldn't bring it into class<br>or even to the school.</html>"
            });
            model.addRow(new String[]{
                "<html>She said she would return it;<br>I'd have it back that day.<br>But then she tried my headphones on<br>and gave a click on Play.</html>"
            });
            model.addRow(new String[]{
                "<html>She looked a little startled,<br>"
                + "but after just a while<br>"
                + "she made sure we were occupied<br>"
                + "and cracked a wicked smile.<br>"
            });
            model.addRow(new String[]{
                "<html>Her body started swaying.<br>"
                + "Her toes began to tap.<br>"
                + "She started grooving in her seat<br>"
                + "and rocking to the rap.</html>"
            });
            model.addRow(new String[]{
                "<html>My teacher said she changed her mind.<br>"
                + "She thinks it's now okay<br>"
                + "to bring my iPod into class.<br>"
                + "She takes it every day.</html>"
            });

            setLayout(new GridBagLayout());

            JTable table = new JTable(model);
            table.setRowHeight(75);
            add(new JScrollPane(table));

        }

    }

}