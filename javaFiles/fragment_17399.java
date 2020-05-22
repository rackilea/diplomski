public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private JLabel editor;

    public ButtonEditor() {
        editor = new JLabel();
        editor.setBackground(Color.GREEN);

        editor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editor.setOpaque(!editor.isOpaque());
                stopCellEditing();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Boolean) {
            boolean result = (boolean) value;
            editor.setOpaque(!result);
        }
        return editor;
    }

    @Override
    public Object getCellEditorValue() {
        return editor.isOpaque();
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }

}