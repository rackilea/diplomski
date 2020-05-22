JTable testTable = new JTable(new Object[][]{{"Value 1", null}}, new Object[] {"Column 1", "Column 2"})
{
  @Override
  public String getToolTipText(MouseEvent event)
  {
    JTable table = (JTable)event.getSource();
    int column = table.columnAtPoint( event.getPoint() );

    if (column == 1)
    {
        int row = table.rowAtPoint( event.getPoint() );
        Rectangle r = table.getCellRect(row, column, false);
        Point p = new Point(event.getX() - r.x, event.getY() - r.y);
//          System.out.println("Width from getToolTipText = " + r.width);

        return p.toString();
    }

    return super.getToolTipText(event);
  }
};