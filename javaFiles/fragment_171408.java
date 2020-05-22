public class JTableWithComboBox {

    private static class ComboBoxCellRenderer extends JComboBox implements TableCellRenderer {

        public ComboBoxCellRenderer(Object[] items) {
            super(items);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setSelectedItem(value);
            return this;
        }
    }

    protected void initUI() {
        JFrame frame = new JFrame("test");
        frame.add(getTable());
        frame.pack();
        frame.setVisible(true);
    }

    private Component getTable() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (int i = 0; i < 1; i++) {
            Vector<String> row = new Vector<String>();
            for (int j = 0; j < 1; j++) {
                row.add("some value");
            }
            data.add(row);
        }
        Vector<String> columns = new Vector<String>();
        columns.add("Column 1");
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setRowHeight(20);
        int i = 0;
        Enumeration<TableColumn> c = table.getColumnModel().getColumns();
        String[] items = {"Item1", "Item2", "Item3"};
        JComboBox combo = new JComboBox(items);
        while (c.hasMoreElements()) {
            TableColumn column = c.nextElement();
            column.setCellRenderer(new ComboBoxCellRenderer(items));
            column.setCellEditor(new DefaultCellEditor(combo));
            combo.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println(e.getItem() + " selected");
                    }
                }
            });
            i++;
        }
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableWithComboBox().initUI();
            }
        });
    }
}