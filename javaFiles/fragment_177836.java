public class ItemModel
extends AbstractTableModel {
    private static final long serialVersionUID = 1;

    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);

        int newRow = items.size() - 1;
        fireTableRowsInserted(newRow, newRow);
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row,
                             int column) {

        Item item = items.get(row);

        switch (column) {
            case 0:
                return item.getName();
            case 1:
                return item.getPrice();
            default:
                throw new IllegalArgumentException(
                    "Invalid column: " + column);
        }
    }

    @Override
    public String getColumnName() {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Price";
            default:
                throw new IllegalArgumentException(
                    "Invalid column: " + column);
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
                // Returning a class which implements/inherits Comprable
                // will cause TableRowSorter to sort
                // by comparing values directly.
                return Double.class;
            default:
                throw new IllegalArgumentException(
                    "Invalid column: " + column);
        }
    }
}