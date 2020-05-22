Button bExpand = new Button(">");
    bExpand.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            expandTreeView(rootItem);
        }
    });