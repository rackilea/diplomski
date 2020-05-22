public final class ScrollingTableFix implements ComponentListener {
  private final JTable table;

  public ScrollingTableFix(JTable table, JScrollPane scrollPane) {
    assert table != null;

    this.table = table;

    table.getModel().addTableModelListener(new ColumnAddFix(table, scrollPane));
  }

  public void componentHidden(final ComponentEvent event) {}

  public void componentMoved(final ComponentEvent event) {}

  public void componentResized(final ComponentEvent event) {
    // turn off resize and let the scroll bar appear once the component is smaller than the table
    if (event.getComponent().getWidth() < table.getPreferredSize().getWidth()) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    // otherwise resize new columns in the table
    else {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
  }

  public void componentShown(final ComponentEvent event) {}

  // similar behavior is needed when columns are added to the table
  private static final class ColumnAddFix implements TableModelListener {
    private final JTable table;
    private final JScrollPane scrollPane;

    ColumnAddFix(JTable table, JScrollPane scrollPane) {
      this.table = table;
      this.scrollPane = scrollPane;
     }

    @Override
    public void tableChanged(TableModelEvent e) {
      if (e.getFirstRow() == TableModelEvent.HEADER_ROW) {
        if (scrollPane.getViewport().getWidth() < table.getPreferredSize().getWidth()) {
          table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        else {
          table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
      }
     }
   }
}