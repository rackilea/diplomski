import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class DeleteAdmin2 extends JPanel {
    private List<JCheckBox> checkBoxes = new ArrayList<>();

    public DeleteAdmin2() {
        JPanel topPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        topPanel.add(new JButton("Back"));
        topPanel.add(new JButton("Delete"));

        String[] texts = { "A1", "B1", "C1", "D1", "E1", "A2", "B2", "C2", "D2", "E2" };
        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 5, 5, 5));
        for (String text : texts) {
            JCheckBox checkBox = new JCheckBox(text);
            checkBoxes.add(checkBox);
            checkBoxPanel.add(checkBox);
        }

        setLayout(new BorderLayout(5, 5));
        add(topPanel, BorderLayout.PAGE_START);
        add(checkBoxPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Delete Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DeleteAdmin2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}