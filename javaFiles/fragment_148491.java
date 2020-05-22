import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class DepotView extends JFrame {

    private JTextArea textArea;
    private JTextArea depotArea;
    private JTextArea workerArea;

    public DepotView() {

        getContentPane().setLayout(new GridBagLayout());

        JPanel workerPanel = createTextAreaPanel("Processing: ", workerArea = new JTextArea());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        getContentPane().add(workerPanel, c);

        JPanel customerPanel = createTextAreaPanel("Customers: ", textArea = new JTextArea());
        c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        getContentPane().add(customerPanel, c);

        JPanel depotPanel = createTextAreaPanel("Depot: ", depotArea = new JTextArea());
        c = new GridBagConstraints();
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        getContentPane().add(depotPanel, c);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createTextAreaPanel(String label, JTextArea textArea) {
        JPanel customerQueuePanel = new JPanel(new BorderLayout());

        customerQueuePanel.add(new JLabel(label), BorderLayout.NORTH);
        textArea.setRows(15);
        textArea.setColumns(20);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        customerQueuePanel.add(scrollPane);
        return customerQueuePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DepotView().setVisible(true);
            }
        });
    }

}