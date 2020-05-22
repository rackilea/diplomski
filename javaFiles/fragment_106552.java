final ListView<String> textsListView = new ListView<>();
    textsListView.focusedProperty().addListener((ov,b,b1)->{
        if(!b1){
            textsListView.requestFocus();
        }
    });

    pagination.setFocusTraversable(false);
    pagination.setPageFactory(page -> {
        textsListView.setItems(
            FXCollections.observableArrayList(texts.subList(page, page + 2)));
        textsListView.getSelectionModel().select(0);

        textsListView.requestFocus();           
        return textsListView;
    });