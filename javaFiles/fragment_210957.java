import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.*;

public class IntroPage2 extends JPanel {
    public static final String TITLE = "Welcome to U.X.Dot.X";
    private JLabel welcomeLabel = new JLabel(TITLE, SwingConstants.CENTER);
    private JButton fbButton = new JButton("Login With Facebook");

    public IntroPage2() {
        fbButton.setBackground(Color.BLUE);
        fbButton.setForeground(Color.CYAN);
        welcomeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        int wlGap = 20;
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(wlGap, wlGap, wlGap, wlGap));

        JLabel registerBelowLabel = new JLabel("Register Below");
        registerBelowLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setPreferredSize(new Dimension(300, 600));
        centralPanel.add(registerBelowLabel);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fbButton, BorderLayout.LINE_START);
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        int ebGap = 8;
        setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
        add(topPanel, BorderLayout.PAGE_START);
        add(centralPanel, BorderLayout.CENTER);
    }

    private static void createAndShowGui() {
        IntroPage2 mainPanel = new IntroPage2();

        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}