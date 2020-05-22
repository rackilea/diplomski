Button bCollapse = new Button("<");
    bCollapse.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            collapseTreeView(rootItem);
        }
    });