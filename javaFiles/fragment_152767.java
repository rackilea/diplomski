import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelTest {

    public static void main(String[] args) {
        // any single component added to this will be centered & have
        // its preferred size honored.
        JPanel constrainSpinnerPanel = new JPanel(new GridBagLayout());
        constrainSpinnerPanel.setBorder(new LineBorder(Color.CYAN, 4));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new LineBorder(Color.RED,4));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(Color.BLUE,4));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel spinPanel1 = new JPanel();
        spinPanel1.setLayout(new BoxLayout(spinPanel1, BoxLayout.X_AXIS));
        spinPanel1.add(new JLabel("top"));
        SpinnerNumberModel spinMod1 = new SpinnerNumberModel(0, 0, 10, 1);
        spinPanel1.add(new JSpinner(spinMod1));
        leftPanel.add(spinPanel1);

        JPanel spinPanel2 = new JPanel();
        spinPanel2.setLayout(new BoxLayout(spinPanel2, BoxLayout.X_AXIS));
        spinPanel2.add(new JLabel("bottom"));
        SpinnerNumberModel spinMod2 = new SpinnerNumberModel(0, 0, 10, 1);
        spinPanel2.add(new JSpinner(spinMod2));
        leftPanel.add(spinPanel2);

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.GREEN, 4));
        rightPanel.setPreferredSize(new Dimension(400, 100));

        constrainSpinnerPanel.add(leftPanel);
        mainPanel.add(constrainSpinnerPanel);
        //mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}