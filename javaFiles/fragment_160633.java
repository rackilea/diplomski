/**
 * Table Model composed from side-by-side table models.
 */
public class ParalleTableModel extends AbstractTableModel {

    private final TableModel[] models;

    public ParalleTableModel(TableModel... models) {
        this.models = models;
    }

    @Override
    public int getRowCount() {
        return models[0].getRowCount();
    }

    @Override
    public int getColumnCount() {
        int count = 0;
        for (TableModel model : models) {
            count += model.getColumnCount();
        }
        return count;
    }

    @Override
    public String getColumnName(int columnIndex) {
        int count = 0;
        for (TableModel model : models) {
            int n = model.getColumnCount();
            if (columnIndex < count) {
                return model.getColumnName(columnIndex - count);
            }
            count += n;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        int count = 0;
        for (TableModel model : models) {
            int n = model.getColumnCount();
            if (columnIndex < count) {
                return model.getColumnClass(columnIndex - count);
            }
            count += n;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        int count = 0;
        for (TableModel model : models) {
            int n = model.getColumnCount();
            if (columnIndex < count) {
                return model.isCellEditable(rowIndex, columnIndex - count);
            }
            count += n;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int count = 0;
        for (TableModel model : models) {
            int n = model.getColumnCount();
            if (columnIndex < count) {
                return model.getValueAt(rowIndex, columnIndex - count);
            }
            count += n;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int count = 0;
        for (TableModel model : models) {
            int n = model.getColumnCount();
            if (columnIndex < count) {
                model.setValueAt(aValue, rowIndex, columnIndex - count);
            }
            count += n;
        }
        throw new IndexOutOfBoundsException();
    }
}