SpreadsheetView spreadsheetView = new SpreadsheetView();
    //off the standard ContextMenu
    spreadsheetView.setContextMenu(null);
   //set own handler for right click with Dialog
    spreadsheetView.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
      @Override public void handle(ContextMenuEvent event) {
        CellView cellView = (CellView) event.getTarget();
        TextInputDialog dialog = new TextInputDialog(cellView.getText());
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
          System.out.println(cellView.getText());
        }
      }
    });