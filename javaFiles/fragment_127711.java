btnNewgroup.addSelectionListener(new SelectionAdapter() {
  @Override
  public void widgetSelected(final SelectionEvent e)
  {
    Rectangle bounds = btnNewgroup.getBounds();

    Point point = btnNewgroup.getParent().toDisplay(bounds.x, bounds.y + bounds.height);

    menu.setLocation(point);

    menu.setVisible(true);
  }
});