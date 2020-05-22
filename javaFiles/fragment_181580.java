import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainGui {
    public static final String SCHUELER_PANEL = "Schueler Panel";
    public static final String EMPTY = "Empty Panel";
    private JPanel mainPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private CardLayout cardLayout = new CardLayout();
    private SchuelerPanel schuelerPanel = new SchuelerPanel();


    public MainGui() {
        mainPanel.setLayout(cardLayout);
        mainPanel.add(new JLabel(), EMPTY); // empty label
        mainPanel.add(schuelerPanel, SCHUELER_PANEL);

        JMenu menu = new JMenu("Panel");
        menu.add(new JMenuItem(new SwapPanelAction(EMPTY)));
        menu.add(new JMenuItem(new SwapPanelAction(SCHUELER_PANEL)));
        menuBar.add(menu);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    @SuppressWarnings("serial")
    private class SwapPanelAction extends AbstractAction {
        public SwapPanelAction(String title) {
            super(title);
            int mnemonic = (int) title.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(mainPanel, (String) getValue(NAME));
        }
    }

    private static void createAndShowGui() {
        MainGui mainGui = new MainGui();
        JFrame frame = new JFrame("Main Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainGui.getMainPanel());
        frame.setJMenuBar(mainGui.getMenuBar());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}