import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CardLayoutExample {
    private static JScrollPane scrollPane;

    public static void main(String[] arguments) throws SQLException {

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame window = new JFrame("CardLayout Example");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // !! window.setSize(1500, 800);
        window.getContentPane().setLayout(new BorderLayout());

        final CardLayout cardLayout = new CardLayout();
        final JPanel cardPanel = new JPanel(cardLayout);

        JPanel card3 = new JPanel();
        cardPanel.add(card3, "All Patients");

        String AllPatients = "select * from tblPtDetails";

        //!!  
        String[][] data = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        String[] columnNames = {"One", "Two", "Three"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        // !! JTable tablePatientDt = new JTable(Bquery.buildTableModel(Bquery.resultQuery(AllPatients)));
        JTable tablePatientDt = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // !! tablePatientDt.setEnabled(false);
        tablePatientDt.setPreferredScrollableViewportSize(new Dimension(1200, 400));
        tablePatientDt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePatientDt.setRowHeight(30);
        tablePatientDt.setAutoCreateRowSorter(true);
        // !! card3.add(tablePatientDt);
        card3.add(new JScrollPane(tablePatientDt), BorderLayout.CENTER);
        for (int i = 0; i < (tablePatientDt.getColumnCount()); i++) {
            TableColumn columnPatients = null;
            columnPatients = tablePatientDt.getColumnModel().getColumn(i);
            columnPatients.setPreferredWidth(70); // sport column is bigger

        }
        tablePatientDt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tablePatientDt.getSelectedRow();
                    int column = tablePatientDt.getSelectedColumn();
                    // Object val= tablePatientDt.getModel().getValueAt(row,
                    // column);
                    // tablePatientDt.getModel().getValueAt(row, column);
                    // return tablePatientDt.getModel().getValueAt(row, column);
                    System.out.println(row);
                    JFrame newFrame = new JFrame();
                    newFrame.setTitle("Detail Screen");
                    newFrame.setVisible(true);
                }
            }
        });

        //!! 
        window.add(cardPanel);
        window.pack();
        window.setVisible(true);
    }
}