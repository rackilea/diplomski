TableColumn<TableViewTest, StringProperty> column = new TableColumn<>("option");
    column.setCellValueFactory(i -> {
        final StringProperty value = i.getValue().optionProperty();
        // binding to constant value
        return Bindings.createObjectBinding(() -> value);
    });

    column.setCellFactory(col -> {
        TableCell<TableViewTest, StringProperty> c = new TableCell<>();
        final ComboBox<String> comboBox = new ComboBox<>(options);
        c.itemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                comboBox.valueProperty().unbindBidirectional(oldValue);
            }
            if (newValue != null) {
                comboBox.valueProperty().bindBidirectional(newValue);
            }
        });
        c.graphicProperty().bind(Bindings.when(c.emptyProperty()).then((Node) null).otherwise(comboBox));
        return c;
    });