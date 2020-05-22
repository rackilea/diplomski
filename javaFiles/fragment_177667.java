import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Gui extends JPanel {
    private JTextField filePathTxtField = new JTextField(45);
    private int foo = 0;

    public Gui() {
        filePathTxtField.setFocusable(false);
        add(filePathTxtField);

        JButton button = new JButton("Get File Path");
        Consumer<String> consumer = (String text) -> {
            filePathTxtField.setText(text);
        };
        button.addActionListener(new PickSomething(consumer));
        add(button);
    }

    private static void createAndShowGui() {
        Gui mainPanel = new Gui();

        JFrame frame = new JFrame("Gui");
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