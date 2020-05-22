import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestTabbedPane100 {

    public static void main(String[] args) {
        new TestTabbedPane100();
    }

    public TestTabbedPane100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTabbedPane tabbedPane;
        private int index;

        public TestPane() {
            setLayout(new BorderLayout());
            tabbedPane = new JTabbedPane();
            addTabs();

            add(tabbedPane);

            JButton btn = new JButton("Update");
            add(btn, BorderLayout.SOUTH);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tabbedPane.removeAll();
                    addTabs();
                }
            });
        }

        protected void addTabs() {
            for (int count = 0; count < 10; count++, index++) {
                tabbedPane.add("Testing" + index, new JLabel("Testing" + index));
            }
        }
    }

}