import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestTabbedPane01 {

    public static void main(String[] args) {
        new TestTabbedPane01();
    }

    private JTabbedPane tabbedPane;

    public TestTabbedPane01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                tabbedPane = new JTabbedPane();
                JButton btnAdd = new JButton("Add");
                btnAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        final JPanel panel = new JPanel(new GridBagLayout());
                        panel.add(new JLabel(String.valueOf(tabbedPane.getComponentCount())));
                        tabbedPane.add(String.valueOf(tabbedPane.getComponentCount()), panel);
                        System.out.println("New Panel Size = " + panel.getSize());
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("New Panel Size (later) = " + panel.getSize());
                            }
                        });
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(tabbedPane);
                frame.add(btnAdd, BorderLayout.SOUTH);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }


}