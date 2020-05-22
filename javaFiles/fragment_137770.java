import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample {

    private GridBagConstraints gbc;
    private JButton[] buttons;

    public GridBagLayoutExample() {
        buttons = new JButton[7];
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
    }

    private void displayGUI() {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new GridBagLayout());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(Integer.toString(i + 1));          
        }
        JLabel informationLabel = new JLabel("Information Text", JLabel.CENTER);
        addComp(contentPane, informationLabel,
                            0, 0, 1.0, 0.20, 4, 1);
        addComp(contentPane, buttons[0],
                            0, 1, 0.25, 0.60, 1, 3);
        JPasswordField passwordField = new JPasswordField(10);
        addComp(contentPane, passwordField,
                            1, 1, 0.50, 0.20, 2, 1);
        addComp(contentPane, buttons[6],
                            1, 2, 0.50, 0.20, 2, 1);
        JTextField tField = new JTextField(10);
        addComp(contentPane, tField,
                            1, 3, 0.50, 0.20, 2, 1);
        addComp(contentPane, buttons[2],
                            3, 1, 0.25, 0.60, 1, 3);
        addComp(contentPane, buttons[1],
                            0, 4, 0.25, 0.20, 1, 1);
        addComp(contentPane, buttons[4],
                            1, 4, 0.25, 0.20, 1, 1);
        addComp(contentPane, buttons[5],
                            2, 4, 0.25, 0.20, 1, 1);
        addComp(contentPane, buttons[3],
                            3, 4, 0.25, 0.20, 1, 1);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void addComp(JPanel panel, JComponent comp,
                        int x, int y, double wx, double wy,
                                int gw, int gh) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;

        panel.add(comp, gbc);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new GridBagLayoutExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}