import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableIssues2 extends JPanel {
    private static final int GAP = 5;
    private static final String[] COL_NAMES = {"One", "Two", "Three"};
    private DefaultTableModel model = new DefaultTableModel(COL_NAMES, 0);
    private JTable patientsTable = new JTable(model);

    public TableIssues2() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
        buttonPanel.add(new JButton("Add"));
        buttonPanel.add(new JButton("Remove"));
        buttonPanel.add(new JButton("Exit"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(buttonPanel);

        for (int i = 0; i < 5; i++) {
            model.addRow(new String[]{"First", "Second", "Third"});
        }
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(new JScrollPane(patientsTable), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        TableIssues2 mainPanel = new TableIssues2();

        JFrame frame = new JFrame("TableIssues2");
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