public class ColorChange extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1;

    private final Collection<Integer> matchingRows;

    public ColorChange(Collection<Integer> matchingRows) {
        this.matchingRows = matchingRows;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        Component c = super.getTableCellRendererComponent(table,
            value, isSelected, hasFocus, row, column);

        if (column != 7) {
            this.setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            this.setHorizontalAlignment(SwingConstants.LEFT);
        }

        if (!isSelected) {
            if (matchingRows.contains(row)) {
                c.setBackground(Color.YELLOW);
            } else {
                c.setBackground(null);
            }
        }

        return c;
    }
}