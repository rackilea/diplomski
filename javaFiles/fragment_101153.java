public class FilterRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        Double percent = (Double) table.getValueAt(row, 3);
        // You'll need some way to supply the filter value, may via a centralised 
        // manager of some kind.
        if (percent > 0.3 && !isSelected) {
            setOpaque(true);
            setBackground(Color.RED);
        } else {
            setOpaque(false);
        }
        return this;
    }
}

public class OtherCellRenderer extends FilterRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        // Apply any special renderer requirements, like translating an object value to String
        return this;
    }
}