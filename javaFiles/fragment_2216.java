public class AATable extends JTable {

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        if (c instanceof JLabel) {
            JLabel l = (JLabel) c;
            String text = l.getText();

            // Do some style transformations maybe...

            l.setText("<html>" + text + "</html>");
        }

        return c;
    }

}