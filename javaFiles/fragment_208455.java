tabbedPane.addTab("FirstRow", createFirstRow(model));
...
private JComponent createFirstRow(DefaultTableModel model) {

    final Font font = new Font("Serif", Font.BOLD, 14);

    JTable table = new JTable(model) {

        public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column) {
            Component c = super.prepareRenderer(renderer, row, column);
            if (!isRowSelected(row)) {
                c.setBackground(row == 0 ? Color.yellow: getBackground());
                c.setFont(row == 0 ? font : getFont());
            }
            return c;
        }
    };

    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    table.changeSelection(1, 1, false, false);
    return new JScrollPane(table);
}