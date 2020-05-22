@FXML
private StackPane stackPaneHolder;
... 

public void setPane(Node node) {
    if (stackPaneHolder.getChildren().isEmpty()) {
        //if stackPaneHolder is empty
        stackPaneHolder.getChildren().add(node);

    } else {
        if (stackPaneHolder.getClip() != node) {
          //if stackPaneHolder is not empty then remove existing layer and add new layer
            stackPaneHolder.getChildren().remove(0);
            stackPaneHolder.getChildren().add(0, node);
        }
    }
}