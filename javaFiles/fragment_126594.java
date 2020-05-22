public static void main(String... args) {

    JFrame frame = new JFrame("Test");

    JTable table = new JTable(10, 2);
    JComboBox box = new JComboBox(new String[] {"A", "B", "C"});
    table.setDefaultEditor(Object.class, new DefaultCellEditor(box) {

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            return super.getTableCellEditorComponent(
                        table, 
                        table.getValueAt(Math.max(row-1, 0), column), 
                        isSelected, 
                        row, 
                        column);
        }
    });

    frame.add(table);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}