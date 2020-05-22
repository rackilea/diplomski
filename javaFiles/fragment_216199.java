import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.table.ColumnFactory;
import org.jdesktop.swingx.table.TableColumnExt;

public class FixedColumnJXTreeTable implements ChangeListener, PropertyChangeListener {
    private JXTreeTable main;
    private JXTreeTable fixed;
    private JScrollPane scrollPane;

    /*
     *  Specify the number of columns to be fixed and the scroll pane
     *  containing the table.
     */
    public FixedColumnJXTreeTable(int fixedColumns, JScrollPane scrollPane) {
        this.scrollPane = scrollPane;

        main = (JXTreeTable) scrollPane.getViewport().getView();
        main.addPropertyChangeListener(this);
        main.setColumnFactory(new FixedColumnJXTreeTableFactory(fixedColumns, false));
        // Use the existing table to create a new table sharing
        // the DataModel and ListSelectionModel

        fixed = new JXTreeTable(main.getTreeTableModel());
        fixed.setSelectionModel(main.getSelectionModel());
        fixed.setFocusable(false);
        fixed.setColumnFactory(new FixedColumnJXTreeTableFactory(fixedColumns, true));
        fixed.addTreeExpansionListener(new TreeExpansionListener() {

            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                main.expandPath(event.getPath());
            }

            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                main.collapsePath(event.getPath());
            }
        });

        scrollPane.setRowHeaderView(fixed);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixed.getTableHeader());

        // Synchronize scrolling of the row header with the main table

        scrollPane.getRowHeader().addChangeListener(this);
    }

    /*
     *  Return the table being used in the row header
     */
    public JTable getFixedTable() {
        return fixed;
    }

    //
    // Implement the ChangeListener
    //
    @Override
    public void stateChanged(ChangeEvent e) {
        // Sync the scroll pane scrollbar with the row header

        JViewport viewport = (JViewport) e.getSource();
        scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
    }

    //
    // Implement the PropertyChangeListener
    //
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        // Keep the fixed table in sync with the main table

        if ("selectionModel".equals(e.getPropertyName())) {
            fixed.setSelectionModel(main.getSelectionModel());
        }

        if ("model".equals(e.getPropertyName())) {
            fixed.setModel(main.getModel());
        }
    }

    private final class FixedColumnJXTreeTableFactory extends ColumnFactory {

        private int fixedColumns;
        private boolean fixedTable;

        public FixedColumnJXTreeTableFactory(int fixedColumns, boolean fixedTable) {
            this.fixedColumns = fixedColumns;
            this.fixedTable = fixedTable;
        }

        @Override
        public TableColumnExt createAndConfigureTableColumn(TableModel model, int modelIndex) {
            // JXTreeTable will not add column if we return null here
            if ((fixedTable && modelIndex >= fixedColumns) || (!fixedTable && modelIndex < fixedColumns)) {
                return null;
            }
            return super.createAndConfigureTableColumn(model, modelIndex);
        }
    }
}