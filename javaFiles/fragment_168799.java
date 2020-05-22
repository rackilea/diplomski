class ComboBoxRenderer extends JComboBox implements TableCellRenderer
{
    public ComboBoxRenderer()
    {
        setBorder(null);
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        removeAllItems();
        addItem( value );

        return this;
    }
}