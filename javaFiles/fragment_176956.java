import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Table model which allows to split another table model in 2 table models.
 * 
 * @author smedvynskyy
 */
public class SplitTableModel implements TableModel, TableModelListener {

    /** Delegate table model. */
    private final TableModel delegate;

    /** Column index used to split the model. */
    private final int splitColumn;

    /**
     * Part of table to represent (leading [0, {@link #splitColumn}), or trailing [{@link #splitColumn}, delegate.getColumnCount() -
     * splitColumn)).
     */
    private final boolean leading;

    private final Collection<TableModelListener> listeners = new LinkedHashSet<>();

    /**
     * Instantiates a new split table model.
     *
     * @param delegate the delegate model to split.
     * @param splitColumn the split position (column).
     * @param leading defines the part of table to represent (leading: [0, {@link #splitColumn}), or trailing: [{@link #splitColumn},
     *            delegate.getColumnCount() - splitColumn)).
     */
    public SplitTableModel(TableModel delegate, int splitColumn, boolean leading) {
        this.delegate = delegate;
        this.splitColumn = splitColumn;
        this.leading = leading;
        delegate.addTableModelListener(this);
    }

    /**
     * Splits the table model in 2 table models.
     * 
     * @param toSplit table model to be split.
     * @param splitColumn split column.
     * @return array of two models which split the given one (first is the left model, second is the right).
     */
    public static TableModel[] split(TableModel toSplit, int splitColumn) {
        return new TableModel[] {new SplitTableModel(toSplit, splitColumn, true), new SplitTableModel(toSplit, splitColumn, false)};
    }

    @Override
    public int getRowCount() {
        return delegate.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return leading ? Math.min(splitColumn, delegate.getColumnCount()) : Math.max(0, delegate.getColumnCount() - splitColumn);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return delegate.getValueAt(rowIndex, toModelColumnIndex(columnIndex));
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    /**
     * Gets all the registered listeners (as unmodifiable collection.
     * 
     * @return all the registered listeners.
     */
    public Collection<TableModelListener> getModelListeners() {
        return Collections.unmodifiableCollection(listeners);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return delegate.getColumnName(toModelColumnIndex(columnIndex));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return delegate.getColumnClass(toModelColumnIndex(columnIndex));
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return delegate.isCellEditable(rowIndex, toModelColumnIndex(columnIndex));
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        delegate.setValueAt(aValue, rowIndex, toModelColumnIndex(columnIndex));

    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int col = e.getColumn() == -1 ? e.getColumn() : toSplitColumnIndex(e.getColumn());
        TableModelEvent evt = new TableModelEvent(this, e.getFirstRow(), e.getLastRow(), col, e.getType());
        listeners.forEach(l -> l.tableChanged(evt));
    }

    /**
     * Gets the delegate table model.
     * 
     * @return delegate table model.
     */
    public TableModel getDelegate() {
        return delegate;
    }

    private int toSplitColumnIndex(int columnIndex) {
        return leading ? columnIndex : columnIndex - splitColumn;
    }

    private int toModelColumnIndex(int columnIndex) {
        return leading ? columnIndex : columnIndex + splitColumn;
    }
}