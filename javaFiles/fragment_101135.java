categoryTableView.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue) ->  {
                   noteTableView.getSelectionModel().clearSelection();
                   showBoardObjectDetails(newValue);
     } );

noteTableView.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue) ->  {
                   categoryTableView.getSelectionModel().clearSelection();
                   showBoardObjectDetails(newValue);
     } );