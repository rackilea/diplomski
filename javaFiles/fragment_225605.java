import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ExampleTemplate {

    private static final int GAP = 5;

    private void displayGUI() {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 1, GAP, GAP));
        contentPane.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));
        contentPane.add(new TemplatePanel());
        contentPane.add(new TemplatePanel());
        contentPane.add(new TemplatePanel());

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new ExampleTemplate().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class TemplatePanel extends JPanel {

    private Random r;
    private JPanel leftPanel;

    private static final int GAP = 5;
    private GridBagConstraints gbc;

    public TemplatePanel() {
        r = new Random();
        setOpaque(true);
        setBackground(getRandomColor());
        setLayout(new BorderLayout(GAP, GAP));      
        JPanel footerPanel = getPanel();
        footerPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(GAP, GAP, GAP, GAP);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;
        leftPanel = getPanel();
        footerPanel.add(leftPanel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.2;
        JLabel rightLabel = new JLabel("Right Label", JLabel.CENTER);
        footerPanel.add(rightLabel);

        JLabel centerLabel = new JLabel("Main Panel", JLabel.CENTER);
        add(centerLabel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.PAGE_END);
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(getRandomColor());

        return panel;
    }

    private Color getRandomColor() {
        return new Color(r.nextFloat(), r.nextFloat(),
                            r.nextFloat(), r.nextFloat());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}