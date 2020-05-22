private static class LogRenderer
    extends JEditorPane implements TableCellRenderer {

    public LogRenderer() {
        this.setEditorKit(new WrapEditorKit());
    }

    public Component getListCellRendererComponent(
        JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {
        this.setText((String) value);
        return this;
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
        this.setText((String) value);
        return this;
    }
}