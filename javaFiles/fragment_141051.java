viewer.addSelectionChangedListener(new ISelectionChangedListener() {
  @Override
  public void selectionChanged(final SelectionChangedEvent event)
  {
    IStructuredSelection selection = (IStructuredSelection)event.getSelection();

    RowData rowData = (RowData)selection.getFirstElement();

    ....
  }
});