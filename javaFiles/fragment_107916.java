import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class FrameFC extends JFrame {

    public static void main(String[] args) {
        new FrameFC();
    }

    private Random random = new Random();    
    private JPanel northPanel = new JPanel();

    private JTable excel = new JTable();
    private JScrollPane currentScrollPane = null;

    public FrameFC() {
        this.setTitle("Gestionnaire de produits");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        northPanel.add(new JButton(new AbstractAction("Change Table") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                tableCreation();
            }
        }));

        add(northPanel, BorderLayout.PAGE_START);
        tableCreation();
        pack();
        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    private void tableCreation() {
        String[] columnNames = {"A", "B", "C"};

        int rowCount = random.nextInt(10) +3;
        Object[][] rowData = new Object[rowCount][columnNames.length];
        for (int i = 0; i < rowData.length; i++) {
            for (int j = 0; j < rowData[i].length; j++) {
                rowData[i][j] = "" + random.nextInt(100) + 50;
            }
        }

        excel = new JTable(rowData, columnNames);
        excel.setAutoCreateRowSorter(true);

        if (currentScrollPane != null) {
            // remove(currentScrollPane);   // ******* here ******
        }
        currentScrollPane = new JScrollPane(excel);

        add(currentScrollPane);
        this.revalidate();
        repaint();
    }

}