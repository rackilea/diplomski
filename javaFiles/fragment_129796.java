@Override
public void start(Stage primaryStage) throws IOException {

    ToggleGroup group = new ToggleGroup();
    VBox vbox = new VBox();

    for (char c = 'a'; c <= 'f'; c++) {
        RadioButton radio = new RadioButton(Character.toString(c));
        radio.setToggleGroup(group);
        vbox.getChildren().add(radio);
    }

    TextField input = new TextField();
    vbox.getChildren().add(input);

    // create map mapping from text to corresponding toggle
    Map<String, Toggle> map = new HashMap<>();      
    for (Toggle t : group.getToggles()) {
        map.put(((RadioButton) t).getText(), t);
    }

    StringProperty property = input.textProperty();

    InvalidationListener listener = new InvalidationListener() {

        // flag preventing circular updating
        boolean updating = false;

        @Override
        public void invalidated(Observable observable) {
            if (!updating) {
                updating = true;

                if (observable == group.selectedToggleProperty()) {
                    // change as result of user interaction with RadioButton

                    // update property
                    RadioButton selectedToggle = (RadioButton) group.getSelectedToggle();
                    property.set(selectedToggle == null ? "" : selectedToggle.getText());
                } else {
                    // change as result of updating the property

                    // select corresponding toggle
                    Toggle toggleToSelect = map.get(property.get());
                    group.selectToggle(toggleToSelect);
                }

                updating = false;
            }
        }

    };

    property.addListener(listener);
    group.selectedToggleProperty().addListener(listener);

    Scene scene = new Scene(vbox);
    primaryStage.setScene(scene);
    primaryStage.show();
}