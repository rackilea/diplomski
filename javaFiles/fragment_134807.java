private Binding<Node> graphicBinding ;

@Override
protected void updateItem(Boolean item, boolean empty) {
    graphicProperty().unbind();
    super.updateItem(item, empty) ;

    MyRow currentRow = getTableRow().getItem();

    if (empty) {
        graphicBinding = null ;
        setGraphic(null);
    } else {
        graphicBinding = Bindings
            .when(currentRow.availableProperty())
            .then(super.getGraphic())
            .otherwise((Node)null);
        graphicProperty.bind(graphicBinding);
    }
}