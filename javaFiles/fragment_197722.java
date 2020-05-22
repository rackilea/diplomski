import java.awt.*;
import javax.swing.*;
public class Test
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                createAndShowGUI ();
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("Test");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane (new MainPanel ());
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class MainPanel extends JPanel
{
    public MainPanel () {
        super (new BorderLayout ());

        JLabel nameAndReg = new JLabel ("My details", SwingConstants.CENTER);
        JLabel errorMsg = new JLabel ("The error message", SwingConstants.CENTER);
        nameAndReg.setForeground(Color.blue);

        JPanel labsPanel = new JPanel (new GridBagLayout ());

        labsPanel.add (nameAndReg);

        GridBagConstraints c = new GridBagConstraints ();
        c.gridy = 1;
        c.insets = new Insets (5, 0, 0, 0);
        labsPanel.add (errorMsg, c);

        JButton butSubmit = new JButton("Submit");
        JButton butReset = new JButton("Reset");

        JTextField redVal = new JTextField(3);
        JTextField greenVal = new JTextField(3);
        JTextField blueVal = new JTextField(3);

        JPanel butPanelSouth = new JPanel ();
        JPanel butPanelNorth = new JPanel ();

        butPanelSouth.add (redVal);
        butPanelSouth.add (greenVal);
        butPanelSouth.add (blueVal);
        butPanelSouth.add (butSubmit);

        butPanelNorth.add (butReset);

        add (labsPanel, BorderLayout.CENTER);
        add (butPanelNorth, BorderLayout.NORTH);
        add (butPanelSouth, BorderLayout.SOUTH);
    }
}