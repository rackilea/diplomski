// register event handler method    
selectionDataCursor.elementProperty().addListener(this::onElementChanged);

// call listener once for initialization:
onElementChanged(selectionDataCursor.elementProperty(), null, selectionDataCursor.getElement());

...

// event handler method
private void onElementChanged(ObservableValue<? extends E> observableValue, E oldValue, E newValue) {
    if (oldValue != null) oldValue.getLabel().setStyle("-fx-text-fill: black");
    if (newValue != null) newValue.getLabel().setStyle("-fx-text-fill: red");
}