class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    private TableCellEditor editor;
    private HashMap<Integer, JComboBox> listDetails = new HashMap<>();

    public void addComboBox(JComboBox combobox) {
        listDetails.put(listDetails.size(), combobox);
    }

    public void setComboBoxForRow(int row, JComboBox combobox) {
        listDetails.put(row, combobox);
    }

    @Override
    public Object getCellEditorValue() {
        if (editor != null) {
            return editor.getCellEditorValue();
        }
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (listDetails.containsKey(row)) {
            editor = new DefaultCellEditor(listDetails.get(row));
        }
        return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
    }
}