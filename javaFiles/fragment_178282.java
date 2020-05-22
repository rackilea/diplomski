@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                               boolean hasFocus, int row, int column)
{
    Point pointInTable = MouseInfo.getPointerInfo().getLocation();
    SwingUtilities.convertPointFromScreen(pointInTable, table);
    Rectangle r = table.getCellRect(row, column, false);
    Point p = new Point(pointInTable.x - r.x, pointInTable.y - r.y);
    table.setToolTipText(p.toString());

  return renderer;
}