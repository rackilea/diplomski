import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {

    private MainFrame owner;
    private JButton showDetailsButton;

    private boolean details = false;

    public MainPanel(MainFrame owner) {
        super();
        this.owner = owner;

        createGUI();
    }

    private void createGUI() {
        showDetailsButton = new JButton("Details >>>");
        showDetailsButton.addActionListener(this::showDetais);

        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(400, 400));
        contentPanel.setBackground(Color.CYAN);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(showDetailsButton);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 400));
        setMinimumSize(getPreferredSize());


        add(contentPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.PAGE_END);
    }

    private void showDetais(ActionEvent event) {
        showDetailsButton.setText(details ? "Details >>>" : "<<< Details");

        details = !details;
        owner.showDetails(details);
    }
}