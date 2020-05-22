public void start(Stage primaryStage) throws Exception {
    ComboBox<String> cba = new ComboBox<>();
    ComboBox<String> cbb = new ComboBox<>();
    cba.getItems().addAll("A", "B", "C");
    cbb.getItems().addAll("123", "456", "789");

    // Set a cell factory for ComboBox A. A similar thing should be done for B. 
    cba.setCellFactory(lv ->
            new ListCell<String>() {
                // This is the node that will display the text and the cross. 
                // I chose a hyperlink, but you can change to button, image, etc. 
                private HBox graphic;

                // this is the constructor for the anonymous class.
                {
                    Label label = new Label();
                    // Bind the label text to the item property. If your ComboBox items are not Strings you should use a converter. 
                    label.textProperty().bind(itemProperty());
                    // Set max width to infinity so the cross is all the way to the right. 
                    label.setMaxWidth(Double.POSITIVE_INFINITY);
                    // We have to modify the hiding behavior of the ComboBox to allow clicking on the hyperlink, 
                    // so we need to hide the ComboBox when the label is clicked (item selected). 
                    label.setOnMouseClicked(event -> cba.hide());

                    Hyperlink cross = new Hyperlink("X");
                    cross.setVisited(true); // So it is black, and not blue. 
                    cross.setOnAction(event ->
                            {
                                // Since the ListView reuses cells, we need to get the item first, before making changes.  
                                String item = getItem();
                                System.out.println("Clicked cross on " + item);
                                if (isSelected()) {
                                    // Not entirely sure if this is needed. 
                                    cba.getSelectionModel().select(null);
                                }
                                // Remove the item from A and add to B. You can add any additional logic in here. 
                                cba.getItems().remove(item);
                                cbb.getItems().add(item);
                            }
                    );
                    // Arrange controls in a HBox, and set display to graphic only (the text is included in the graphic in this implementation). 
                    graphic = new HBox(label, cross);
                    graphic.setHgrow(label, Priority.ALWAYS);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                }

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(graphic);
                    }
                }
            });

    // We have to set a custom skin, otherwise the ComboBox disappears before the click on the Hyperlink is registered. 
    cba.setSkin(new ComboBoxListViewSkin<String>(cba) {
        @Override
        protected boolean isHideOnClickEnabled() {
            return false;
        }
    });

    VBox vb = new VBox(cba, cbb);
    primaryStage.setScene(new Scene(vb));
    primaryStage.show();
}