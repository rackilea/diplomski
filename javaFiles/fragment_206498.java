import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Test101 {

    public static void main(String[] args) {
        new Test101();
    }

    public Test101() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable table = new JTable();
                InputMap im = table.getInputMap();
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Action.NextCell");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "Action.NextCell");

                ActionMap am = table.getActionMap();
                am.put("Action.NextCell", new NextCellActioin(table));

                DefaultTableModel model = new DefaultTableModel(10, 10);
                table.setModel(model);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class NextCellActioin extends AbstractAction {

        private JTable table;

        public NextCellActioin(JTable table) {
            this.table = table;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();

            int colCount = table.getColumnCount();
            int rowCount = table.getRowCount();

            col++;
            if (col >= colCount) {
                col = 0;
                row++;
            }

            if (row >= rowCount) {
                row = 0;
            }

            table.getSelectionModel().setSelectionInterval(row, row);
            table.getColumnModel().getSelectionModel().setSelectionInterval(col, col);
        }

    }

}