public class AATableRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        DefaultTableCellRenderer c = (DefaultTableCellRenderer) super
                .getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);

        String text = c.getText();

        // Do some style transformations maybe...

        c.setText("<html>" + text + "</html>");

        return c;
    }

}