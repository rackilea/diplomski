public class MyTable extends JTable {

    // [snip]

    private Border paddingBorder = BorderFactory.createEmptyBorder(2, 3, 2, 3);

    // [snip]

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);

        if (JComponent.class.isInstance(comp)){
            ((JComponent)comp).setBorder(paddingBorder);
        }

        // [snip]
    }

    // [snip]

}