import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class PanelFC extends JPanel {
    private static final String[] COLUMN_NAMES = {"A", "B", "C"};
    private Random random = new Random();    
    private JPanel northPanel = new JPanel();    
    private JTable excel = new JTable(modelCreation());

    public PanelFC() {
        northPanel.add(new JButton(new CreateModelAction("Create Model")));

        setLayout(new BorderLayout());

        add(northPanel, BorderLayout.PAGE_START);
        add(new JScrollPane(excel), BorderLayout.CENTER);
    }

    private TableModel modelCreation() {
        // your code will take some parameter, and using database query 
        // result, create the table model
        // Also, all database code should be called in a background thread
        int rowCount = random.nextInt(10) +3;
        Object[][] rowData = new Object[rowCount][COLUMN_NAMES.length];
        for (int i = 0; i < rowData.length; i++) {
            for (int j = 0; j < rowData[i].length; j++) {
                rowData[i][j] = "" + random.nextInt(100) + 50;
            }
        }        
        DefaultTableModel model = new DefaultTableModel(rowData, COLUMN_NAMES);
        return model;
    }

    private class CreateModelAction extends AbstractAction {
        public CreateModelAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            excel.setModel(modelCreation());
        }
    }

    private static void createAndShowGui() {
        PanelFC mainPanel = new PanelFC();

        JFrame frame = new JFrame("PanelFC");
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