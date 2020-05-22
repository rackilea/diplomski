public class PartidaCustomRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, null, isSelected, hasFocus, row, column);

        String text = (String)value;
        if (column == 5 && text.equals("RED")) {
            setBackground(Color.red);
        } else if (column == 5 && text.equals("GREEN")) {
            setBackground(Color.green);
        }

        return this;
    }

    private int getAlinhamento(int coluna) {
        switch (coluna) {
            case 0:
                return SwingConstants.CENTER;
            case 1:
                return SwingConstants.LEFT;
            case 2:
            default:
                return SwingConstants.RIGHT;
        }
    }
}