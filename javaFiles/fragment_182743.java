import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MainGui2 extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private WelcomePanel welcomePanel = new WelcomePanel(this);
    private HomePanel homePanel = new HomePanel();

    public MainGui2() {
        setLayout(cardLayout);
        add(welcomePanel, WelcomePanel.NAME);
        add(homePanel, HomePanel.NAME);
    }

    public void showCard(String name) {
        cardLayout.show(this, name);
    }

    private static void createAndShowGui() {
        MainGui2 mainPanel = new MainGui2();

        JFrame frame = new JFrame("MainGui2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

}

class WelcomePanel extends JPanel {
    public static final String NAME = "welcome panel";
    private MainGui2 mainGui2;

    public WelcomePanel(final MainGui2 mainGui2) {
        this.mainGui2 = mainGui2;
        add(new JLabel(NAME));
        add(new JButton(new AbstractAction("Logon") {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui2.showCard(HomePanel.NAME);
            }
        }));
    }
}

class HomePanel extends JPanel {
    public static final String NAME = "home panel";

    public HomePanel() {
        add(new JLabel(NAME));
    }
}