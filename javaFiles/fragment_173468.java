import java.awt.BorderLayout;
import javax.swing.*;

public class SimpleLayout extends JPanel {
    private static final int ROWS = 20;
    private static final int COLS = 60;
    private JTextArea textArea = new JTextArea(ROWS, COLS);
    private JButton button = new JButton("Button");

    public SimpleLayout() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        SimpleLayout mainPanel = new SimpleLayout();

        JFrame frame = new JFrame("SimpleLayout");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}