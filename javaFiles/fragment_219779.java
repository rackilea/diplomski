import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameTest extends JFrame implements ActionListener {

    JComboBox test;

    public FrameTest() {
        setLayout(new FlowLayout());
        setSize(550, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton hideJCombo = new JButton("Hide my JCombobox!");
        JButton showJCombo = new JButton("Show my JCombobox!");

        String course[] = {"This", "is", "a", "sample", "for", "StackOverflow"};
        test = new JComboBox(course);

        add(hideJCombo);
        add(test);
        add(showJCombo);


        hideJCombo.setActionCommand("hide");
        showJCombo.setActionCommand("show");

        hideJCombo.addActionListener(this);
        showJCombo.addActionListener(this);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrameTest().setVisible(true);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("hide".equals(e.getActionCommand())) {
            test.setVisible(false);
            System.out.println("hide");
        } else if ("show".equals(e.getActionCommand())) {
            test.setVisible(true);
        }

    }
}