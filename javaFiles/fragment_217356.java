public class MousePopupHandler extends MouseAdapter {

    private JTable table;
    private JPopupMenu popupMenu;

    public MousePopupHandler(JTable table, JPopupMenu popupMenu) {
        this.table = table;
        this.popupMenu = popupMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        doPopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        doPopup(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        doPopup(e);
    }

    protected void doPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            int x = e.getPoint().x;
            int y = e.getPoint().y;
            int row = table.rowAtPoint(e.getPoint());
            int col = table.columnAtPoint(e.getPoint());
            table.setRowSelectionInterval(row, row);
            table.setColumnSelectionInterval(col, col);
            popupMenu.show(table, x, y);
        }
    }

}