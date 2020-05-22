import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                DefaultTableModel dtm = new DefaultTableModel(0, 0);
                // add header of the table
                String header[] = new String[]{"Id", "Descrizione", "Stato", "Data inizio", "Tipo", "Responsabile"};
                // add header in table model     
                dtm.setColumnIdentifiers(header);
                //set model into the table object

                // add row dynamically into the table  
                // for now only dummy data
                for (int count = 1; count <= 3; count++) {
                    dtm.addRow(new Object[]{Integer.toString(count), "data", "data",
                                                                    "data", "data", "data"});
                }

                JTable table = new JTable(dtm);

                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(new AddRowAction(table, dtm));
                popupMenu.add(new EditRowAction(table, dtm));
                popupMenu.add(new DeleteRowAction(table, dtm));

                table.addMouseListener(new MousePopupHandler(table, popupMenu));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MousePopupHandler extends MouseAdapter {

        private JTable table;
        private JPopupMenu popupMenu;

        public MousePopupHandler(JTable table, JPopupMenu popupMenu) {
            this.table = table;
            this.popupMenu = popupMenu;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            doPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            doPopup(e);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            doPopup(e);
        }

        protected void doPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                int x = e.getPoint().x;
                int y = e.getPoint().y;
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                table.setRowSelectionInterval(row, row);
                table.setColumnSelectionInterval(col, col);
                popupMenu.show(table, x, y);
            }
        }

    }

    public abstract class AbstractTableAction<TM extends TableModel> extends AbstractAction {

        private JTable table;
        private TM model;

        public AbstractTableAction(JTable table, TM model) {
            this.table = table;
            this.model = model;
        }

        public TM getModel() {
            return model;
        }

        public JTable getTable() {
            return table;
        }

        public int getSelectedRow() {
            return getTable().getSelectedRow();
        }

        public int getSelectedColumn() {
            return getTable().getSelectedColumn();
        }
    }

    public class AddRowAction extends AbstractTableAction<DefaultTableModel> {

        public AddRowAction(JTable table, DefaultTableModel model) {
            super(table, model);
            putValue(NAME, "Add");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Add @ " + getSelectedRow() + "x" + getSelectedColumn());
        }

    }

    public class DeleteRowAction extends AbstractTableAction<DefaultTableModel> {

        public DeleteRowAction(JTable table, DefaultTableModel model) {
            super(table, model);
            putValue(NAME, "Delete");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete @ " + getSelectedRow() + "x" + getSelectedColumn());
        }

    }

    public class EditRowAction extends AbstractTableAction<DefaultTableModel> {

        public EditRowAction(JTable table, DefaultTableModel model) {
            super(table, model);
            putValue(NAME, "Edit");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Edit @ " + getSelectedRow() + "x" + getSelectedColumn());
        }

    }
}