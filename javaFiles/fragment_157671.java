private JTable table;
private int index;
private void startAnimation() {
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            index++;
            if (index > table.getRowCount() * table.getColumnCount())
                index = 0;
            table.repaint();
        }
    });
    timer.setRepeats(true);
    timer.start();
}
class PaintCell extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Component c = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        int id = row * table.getRowCount() + column;
        c.setBackground(id < index ? Color.RED : null);
        return c;
    }
}