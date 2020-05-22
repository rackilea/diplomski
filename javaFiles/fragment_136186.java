public class SpringTable extends JTable {

    public SpringTable(TableModel dm) {
        super(dm);
        setAutoResizeMode(AUTO_RESIZE_OFF);
    }

    public SpringTable() {
        setAutoResizeMode(AUTO_RESIZE_OFF);
    }

    @Override
    public void doLayout() {
        int width = getWidth();
        int columnCount = getColumnCount();
        int columnSize = width / columnCount;
        for (int index = 0; index < columnCount; index++) {
            TableColumn column = getColumnModel().getColumn(index);
            column.setResizable(false);
            column.setPreferredWidth(width);
        }
        super.doLayout();
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

}