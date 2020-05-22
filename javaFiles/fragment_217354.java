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