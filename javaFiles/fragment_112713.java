b.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    List items =  new ArrayList (treeTable.getSelectionModel().getSelectedItems());  
                    data.removeAll(items);
                    table.getSelectionModel().clearSelection();

                }
            });