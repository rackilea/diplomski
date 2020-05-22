bExpand.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            for(TreeItem<?> child: rootItem.getChildren()){
                expandTreeView(child);
            }
        }
    });
    bCollapse.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            for(TreeItem<?> child: rootItem.getChildren()){
                collapseTreeView(child);
            }
        }
    });