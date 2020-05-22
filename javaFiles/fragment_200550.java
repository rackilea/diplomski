public void mouseClicked(MouseEvent event)
{
  if (event.getClickCount() == 2)
  {
    JTable source = (JTable)event.getSource();
    int rowIndex = source.rowAtPoint(event.getPoint());
    // get data from table model using row index
    // navigate to panel
  }
}