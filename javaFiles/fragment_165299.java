import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        detailsPanel = new DetailsPanel();

        add(new MainPanel(this), BorderLayout.CENTER);
        add(detailsPanel, BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }

    public void showDetails(boolean show) {
        detailsPanel.setVisible(show);

        pack();
        setLocationRelativeTo(null);
    }
}