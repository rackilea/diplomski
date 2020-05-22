@Override
public void start(Stage primaryStage) {
    ComboBox<String> c1 = new ComboBox<>();
    c1.getItems().addAll("apple", "orange", "banana");
    ComboBox<String> c2 = new ComboBox<>();
    c2.getItems().addAll("water", "coffee", "juice");
    ComboBox<String> c3 = new ComboBox<>();
    ChangeListener<String> listener = (o, oldValue, newValue) -> {
        final List<String> items = c3.getItems();
        int index = items.indexOf(oldValue);
        if (index >= 0) {
            if (newValue == null) {
                items.remove(index);
            } else {
                items.set(index, newValue);
            }
        } else if (newValue != null) {
            items.add(newValue);
        }
    };
    c1.valueProperty().addListener(listener);
    c2.valueProperty().addListener(listener);

    final VBox vBox = new VBox(c1, c2, c3);
    primaryStage.setScene(new Scene(vBox));
    primaryStage.show(); 
}