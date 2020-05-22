import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Test {

    private JFrame frame;
    private JTextField nameTextField, birthDateTextField;
    private JLabel nameLabel, birthDateLabel;

    public Test() {
        initComponents();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
                new Test();
            }
        });
    }

    private void initComponents() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        nameTextField = new JTextField(30);
        birthDateTextField = new JTextField(30);
        nameLabel = new JLabel("Name:");
        birthDateLabel = new JLabel("Birth Date:");

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 10, 10);

        gc.gridx = 0;
        gc.gridy = 0;
        frame.add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        frame.add(nameTextField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        frame.add(birthDateLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        frame.add(birthDateTextField, gc);

        frame.pack();
        frame.setVisible(true);
    }
}