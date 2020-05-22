public class TableDeleteButtonEditor extends AbstractCellEditor implements TableCellEditor {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton button;
    boolean isPushed;

    public TableDeleteButtonEditor() {
        button = new JButton();
        button.addActionListener(new DeleteButtonListener());
    }

    public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        button.setText((value == null) ? "" : value.toString());
        isPushed = false;
        return button;
    }

    public Object getCellEditorValue() {
        return isPushed;
    }

    public class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            isPushed = true;
            stopCellEditing();
        }
    }
}