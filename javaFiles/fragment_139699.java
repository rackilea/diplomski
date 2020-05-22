tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {

  @Override
  public void onSelection(SelectionEvent<Integer> event) {
      String tabHtml = tabPanel.getTabBar().getTabHTML(event.getSelectedItem());
    }
  });