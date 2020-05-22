MouseListener columnSelectionMouseListener = new ColumnSelectionMouseListener();
getViewer().getTable().addMouseListener(columnSelectionMouseListener);

public class ColumnSelectionMouseListener implements MouseListener {

    private TableColumn selectedColumn;

    @Override
    public void mouseDoubleClick(MouseEvent e) {
        // Nothing to do here
    }

    @Override
    public void mouseDown(MouseEvent e) {
        table = (Table) e.widget;
    TableItem item = table.getItem(new Point(e.x, e.y));
    for (int i = 0; i < table.getColumnCount(); i++) {
        TableColumn column = table.getColumn(i);
        Rectangle bounds = item.getBounds(i);
        if (bounds.contains(e.x, e.y)) {
            selectedColumn = column;
        }
    }
    }

    @Override
    public void mouseUp(MouseEvent e) {
        // Nothing to do here
    }

    public TableColumn getSelectedField() {
           return selectedColumn;
    }
}