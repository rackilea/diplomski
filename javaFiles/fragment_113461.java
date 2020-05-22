import javax.swing.*;

public class View2 {
    private JPanel mainPanel = new JPanel();
    private JTextField textField = new JTextField(10);

    public View2() {
        textField.setFocusable(false);
        mainPanel.add(new JLabel("Text:"));
        mainPanel.add(textField);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public void show() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("View");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(getMainPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}