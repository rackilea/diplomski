final ListView<String> textsListView = new ListView<>();
    final BooleanProperty loaded=new SimpleBooleanProperty(false);         

    pagination.setFocusTraversable(false);
    pagination.setPageFactory(page -> {
        textsListView.setItems(
             FXCollections.observableArrayList(texts.subList(page, page + 2)));
        textsListView.getSelectionModel().select(0);

        loaded.set(true);
        return textsListView;
    });

    loaded.addListener((ov,b,b1)->{
        if(b1){
            textsListView.requestFocus();
            loaded.set(false);
        }
    });