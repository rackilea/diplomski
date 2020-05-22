import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class CardPanel {

    public static void main(String[] args) throws Exception {
        CardLayout cardLayout = new CardLayout();
        JFrame frame = new JFrame("Welcome");
        JPanel contentPane = new JPanel(cardLayout);
        contentPane.setBackground(Color.RED);

        ImageIcon imageIcon = new ImageIcon(new URL("https://i.stack.imgur.com/OVOg3.jpg"));
        JLabel logo = new JLabel(imageIcon);

        JPanel buttonsPanel = new JPanel();
        JButton login = new JButton("Login");
        buttonsPanel.add(login);

        buttonsPanel.setOpaque(false);

        contentPane.add(logo, "logo");
        contentPane.add(buttonsPanel, "button");

        cardLayout.show(contentPane, "button");

        frame.add(contentPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}