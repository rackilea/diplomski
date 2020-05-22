//options is populated with some strings
options = FXCollections.observableArrayList();
listView = new ListView<String>();
listView.setPrefHeight(390);

listView.setItems(options);
listView.getStyleClass().add("scs-listview-dialog");

setListViewFactory();

listView.getSelectionModel().select(0);
...
...
    private void setListViewFactory()
{
    listView.setCellFactory(
            (final ListView<String> p) -> new ListCell<String>()
            {
                @Override
                protected void updateItem(final String item, final boolean empty)
                {
                    super.updateItem(item, empty);
                    if (item != null)
                    {
                        Platform.runLater(() ->
                        {
                            this.setGraphic(makeGridPane(item));
                        });
                    }
                }
            });
}

private GridPane makeGridPane(final String item)
{
    final GridPane gridPane = new GridPane();
    final ColumnConstraints col1 = new ColumnConstraints();
    final ColumnConstraints col2 = new ColumnConstraints();
    col1.setHalignment(HPos.LEFT);
    col1.setMinWidth(105);
    col2.setHalignment(HPos.RIGHT);
    col2.setMinWidth(105);
    gridPane.getColumnConstraints().addAll(col1, col2);

    final HBox spacer = new HBox();
    spacer.setMinWidth(10);

    final Label optionLabel = new Label(item); 

    ColorPicker colorPicker = new ColorPicker();
    colorPicker.getStyleClass().add("colorPicker");

    colorPicker.setOnMouseClicked((e) -> 
    {
        listView.getSelectionModel().select(item);
    });

    colorPicker.setOnAction((ActionEvent t) -> 
    {
        Color color = colorPicker.getValue();

        String selectedItem = listView.getSelectionModel().getSelectedItem();
        PyDevThemes pyDevThemeItem = PyDevThemes.valueByListItem(selectedItem);

        getCurrentThemeValuesMap().put(pyDevThemeItem.getId(), colorToRGB(color));
        updateLabelColoring(selectedItem, color);
    });

    GridPane.setConstraints(optionLabel, 0, 0);
    GridPane.setConstraints(colorPicker, 1, 0);
    gridPane.getChildren().addAll(optionLabel, colorPicker);
    return gridPane;
}