import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

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
            JPanel p1 = new JPanel();
            p1.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, null, null));
            JPanel p2 = new JPanel();
            p2.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, UIManager.getFont("Label.font").deriveFont(Font.BOLD), null));
            JPanel p3 = new JPanel();
            p3.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, UIManager.getFont("Label.font").deriveFont(Font.ITALIC), null));
            JPanel p4 = new JPanel();
            p4.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, UIManager.getFont("Label.font").deriveFont(Font.BOLD | Font.ITALIC), null));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;

            add(p1, gbc);
            add(p2, gbc);
            add(p3, gbc);
            add(p4, gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}