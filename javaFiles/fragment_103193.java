import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestCardLayout {

    public static void main(String[] args) {
        new TestCardLayout();
    }

    private int index = 0;

    public TestCardLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final CardLayout cl = new CardLayout();
                final JPanel cardPane = new JPanel(cl);
                cardPane.add(new JLabel("Hello"), "1");
                cardPane.add(new JScrollPane(createForm()), "2");

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(cardPane);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                JButton next = new JButton("Next");
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        index++;
                        if (index > 1) {
                            index = 0;
                        }
                        if (index == 0) {
                            cl.show(cardPane, "1");
                        } else { 
                            cl.show(cardPane, "2");
                        }
                    }
                });
                frame.add(next, BorderLayout.SOUTH);
            }

        });
    }

    public JPanel createForm() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        for (int index = 0; index < 100; index++) {
            form.add(new JTextField(10), gbc);
        }
        return form;
    }
}