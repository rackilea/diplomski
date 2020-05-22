import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Arsti3 {

    private static final int WIDE = 100;
    private JFrame main = new JFrame("Arst");
    private JPanel tP = new JPanel(new GridLayout());
    private JPanel bP = new JPanel();
    private JButton one = new JButton("One");
    private JButton two = new JButton("Two");
    private Vector<String> columnNames = new Vector<String>();
    private Vector<Object> data = new Vector<Object>();
    private DefaultTableModel model = new DefaultTableModel(data, columnNames);
    private JTable table = new JTable();

    Arsti3() {
        reloadData();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn col = table.getColumnModel().getColumn(i);
            col.setPreferredWidth(WIDE);
            col.setMaxWidth(WIDE * 5);
        }
        table.setPreferredScrollableViewportSize(new Dimension(
            table.getColumnCount() * WIDE, table.getRowHeight() * 16));
        tP.add(new JScrollPane(table));
        bP.add(one);
        bP.add(two);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.add(tP, BorderLayout.CENTER);
        main.add(bP, BorderLayout.SOUTH);
        main.pack();
        main.setVisible(true);

    }

    private void reloadData() {
        // could be factored out
        columnNames.clear();
        columnNames.addElement("ID");
        columnNames.addElement("Vards");
        columnNames.addElement("Uzvards");
        columnNames.addElement("Dzimums");
        columnNames.addElement("Personas kods");
        columnNames.addElement("Telefona numurs");
        columnNames.addElement("Nodalas ID");
        columnNames.addElement("Amata ID");
        model.setRowCount(0); // clear rows
        // add rows here
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Arsti3();
            }
        });
    }
}