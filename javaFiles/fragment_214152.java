import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class Experiment2 extends JPanel {
    private static final int ROWS = 20;
    private static final int COLUMNS = 50;
    private static final int GAP = 3;
    // create the JTextArea, setting its rows and columns properties
    private JTextArea tarea = new JTextArea(ROWS, COLUMNS);
    private JTextField textField = new JTextField(COLUMNS);

    public Experiment2() {
        // create the JScrollPane and pass in the JTextArea
        JScrollPane scrollPane = new JScrollPane(tarea);

        // let's create another JPanel to hold some buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
        buttonPanel.add(new JButton("Save"));
        buttonPanel.add(new JButton("Load"));
        buttonPanel.add(new JButton("Whatever"));
        buttonPanel.add(new JButton("Exit"));

        // create JPanel for the bottom with JTextField and a button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(textField);
        bottomPanel.add(Box.createHorizontalStrut(GAP));
        bottomPanel.add(new JButton("Submit"));

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        // use BorderLayout to add all together
        setLayout(new BorderLayout(GAP, GAP));
        add(scrollPane, BorderLayout.CENTER);  // add scroll pane to the center
        add(buttonPanel, BorderLayout.PAGE_START);  // and the button panel to the top
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        Experiment2 mainPanel = new Experiment2();

        JFrame frame = new JFrame("Experiment 2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}