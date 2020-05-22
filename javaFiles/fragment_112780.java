import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.prompt.BuddySupport;
import org.jdesktop.swingx.prompt.PromptSupport;

public class PromptSupportTest {

    public static void main(String[] args) {
        new PromptSupportTest();
    }

    public PromptSupportTest() {
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
            JTextField firstName = new JTextField(10);
            PromptSupport.setPrompt("First Name", firstName);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, firstName);

            JTextField lastName = new JTextField(10);
            PromptSupport.setPrompt("Last Name", lastName);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, lastName);

            JTextField picture = new JTextField(10);
            PromptSupport.setPrompt("Picture", picture);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, picture);

            JButton browse = new JButton("...");
            browse.setMargin(new Insets(0, 0, 0, 0));
            browse.setContentAreaFilled(false);
            browse.setFocusPainted(false);
            browse.setFocusable(false);
            browse.setOpaque(false);
            // Add action listener to brose button to show JFileChooser...

            BuddySupport.addRight(browse, picture);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;

            add(firstName, gbc);
            add(lastName, gbc);
            add(picture, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            add(new JButton("Ok"), gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}