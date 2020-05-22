@Override
public void start(Stage primaryStage) {
    ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(
            "item 1",
            "item 2",
            "item 3",
            "item 4",
            "item 5"
    ));

    final Font BOLD_FONT = Font.font("System", FontWeight.BOLD, 14);
    final Font NORMAL_FONT = Font.font("System", FontWeight.NORMAL, 14);

    final StringProperty defaultValue = new SimpleStringProperty();
    comboBox.setCellFactory(lv -> new ListCell<String>() {

        {
            // use bold font if the item property contains the
            // same value as the defaultValue property
            fontProperty().bind(Bindings.when(itemProperty().isEqualTo(defaultValue))
                                        .then(BOLD_FONT)
                                        .otherwise(NORMAL_FONT));
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
            } else {
                setText(item);
            }
        }

    });

    // change default every second
    PauseTransition animation = new PauseTransition(Duration.seconds(1));
    EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {

        private Iterator<String> iterator = comboBox.getItems().iterator();

        @Override
        public void handle(ActionEvent event) {
            if (!iterator.hasNext()) {
                iterator = comboBox.getItems().iterator();
            }
            defaultValue.set(iterator.next());
            animation.play();
        }
    };

    animation.setOnFinished(eventHandler);

    eventHandler.handle(null);
    Scene scene = new Scene(comboBox);

    primaryStage.setScene(scene);
    primaryStage.show();
}