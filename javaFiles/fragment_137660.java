private final JTable table = new JTable(model) {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        Component c = super.prepareRenderer(renderer, row, col);
        if (col == DATE_COL) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((Date) model.getValueAt(row, col));
            c.setEnabled(calendar.get(Calendar.DAY_OF_MONTH) % 2 == 0);
        }
        return c;
    }
};