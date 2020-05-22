import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestScrollPane {

    public static void main(String[] args) {
        new TestScrollPane();
    }

    public TestScrollPane() {
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
                frame.add(new HiraganaPage());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class HiraganaPage extends JPanel {

        JFrame frame = new JFrame("Hello");
        JButton kanas[][] = new JButton[26][5];
        JButton backButton = new JButton("back");
        JPanel backPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        public HiraganaPage() {
            setLayout(new BorderLayout());

            JPanel pane = new JPanel();
            backPanel.add(backButton);
            buttonsPanel.setLayout(new GridLayout(0, 5));
            pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
            pane.add(backPanel);

//            pane.setPreferredSize(new Dimension(500, 500));

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 5; j++) {
                    kanas[i][j] = new JButton("1");
                    buttonsPanel.add(kanas[i][j]);
                }
            }

            add(pane, BorderLayout.NORTH);
            add(new JScrollPane(buttonsPanel));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }
    }

}