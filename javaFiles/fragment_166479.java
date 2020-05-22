import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Simple table model for displaying properties common to all objects.
 * Note that all methods must run inside the event dispatch thread.
 */
public class ObjectPropertyTableModel extends AbstractTableModel {
    private final List<Object> objects = new ArrayList<Object>();

    public void addObject(Object obj) {
        addObject(obj, objects.size());
    }

    public void addObject(Object obj, int index) {
        objects.add(index, obj);
        fireTableRowsInserted(index, index);
    }

    public void removeObject(Object obj) {
        int index = objects.indexOf(obj);
        objects.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Object getObject(int rowIndex) {
        return objects.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return objects.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
        case 0: return "toString";
        case 1: return "hashCode";
        case 2: return "class";
        default: throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0: return String.class;
        case 1: return Integer.class;
        case 2: return Class.class;
        default: throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = objects.get(rowIndex);
        switch (columnIndex) {
        case 0: return obj.toString();
        case 1: return obj.hashCode();
        case 2: return obj.getClass();
        default: throw new IndexOutOfBoundsException();
        }
    }
}