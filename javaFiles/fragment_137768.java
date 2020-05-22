import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyFrame1 extends JFrame {
    MyFrame1(String title) {
        super(title);
    }

    private JPanel mainPanel;
    private GridBagConstraints gbc = new GridBagConstraints();
    private GridBagLayout gbLayout = new GridBagLayout();

    void init() {
        mainPanel = new JPanel();
        mainPanel.setLayout(gbLayout);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        this.setContentPane(mainPanel);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JCheckBox italic = new JCheckBox("Italic");
        gbLayout.setConstraints(italic, gbc);
        mainPanel.add(italic);

        JCheckBox bold = new JCheckBox("Bold");
        gbc.gridy = 3;
        gbLayout.setConstraints(bold, gbc);
        mainPanel.add(bold);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JRadioButton times = new JRadioButton("Times");
        gbLayout.setConstraints(times, gbc);
        mainPanel.add(times, gbc);

        gbc.gridy = 2;
        JRadioButton helv = new JRadioButton("Helvatica");
        gbLayout.setConstraints(helv, gbc);
        mainPanel.add(helv, gbc);

        gbc.gridy = 4;
        JRadioButton courier = new JRadioButton("Courier");
        gbLayout.setConstraints(courier, gbc);
        mainPanel.add(courier, gbc);


        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        MyFrame1 f = new MyFrame1("Font Chooser");
        f.init();
    }
}