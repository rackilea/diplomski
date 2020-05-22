class Value implements Comparable<Value> {

    private Boolean selected;
    private Integer value;

    public Value(Boolean selected, Double value) {
        this.selected = selected;
        this.value = value;
    }
    …
}

class ValueRenderer extends JCheckBox
    implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        Value v = (Value) value;
        this.setSelected(v.selected);
        this.setText(df.format(v.value));
        …
        return this;
    }
}

class ValueEditor extends AbstractCellEditor implements TableCellEditor, ItemListener {

    private ValueRenderer vr = new ValueRenderer();

    public ValueEditor() {
        vr.addItemListener(this);
    }

    @Override
    public Object getCellEditorValue() {
        return vr.isSelected();
    }
    …
}
…
table.setDefaultRenderer(Value.class, new ValueRenderer());
table.setDefaultEditor(Value.class, new ValueEditor());