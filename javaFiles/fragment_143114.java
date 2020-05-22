private static HBox createModesRadios(IntegerProperty count, Mode... modes) {
    ToggleGroup group = new ToggleGroup();
    HBox result = new HBox(10);
    for (Mode mode : modes) {
        RadioButton radio = new RadioButton(mode.getText());
        radio.setToggleGroup(group);
        radio.setUserData(mode);
        result.getChildren().add(radio);
    }
    if (modes.length > 0) {
        group.selectToggle((Toggle) result.getChildren().get(0));
        count.bind(Bindings.createIntegerBinding(() -> ((Mode) group.getSelectedToggle().getUserData()).getCount(), group.selectedToggleProperty()));
    } else {
        count.set(0);
    }
    return result;
}

private static void updateCheckBoxes(CheckBox[] checkBoxes, int requiredCount, int unmodifiedIndex) {
    if (unmodifiedIndex >= 0 && checkBoxes[unmodifiedIndex].isSelected()) {
        requiredCount--;
    }
    int i;
    for (i = 0; i < checkBoxes.length && requiredCount > 0; i++) {
        if (i != unmodifiedIndex && checkBoxes[i].isSelected()) {
            requiredCount--;
        }
    }

    for (; i < checkBoxes.length; i++) {
        if (i != unmodifiedIndex) {
            checkBoxes[i].setSelected(false);
        }
    }
}

@Override
public void start(Stage primaryStage) {
    Mode[] modes = new Mode[]{
        new Mode("Vertical", 4),
        new Mode("Hybrid", 2),
        new Mode("Horizontal", 1)
    };

    ToggleGroup group = new ToggleGroup();
    IntegerProperty elementCount = new SimpleIntegerProperty();

    HBox radioBox = createModesRadios(elementCount, modes);
    GridPane grid = new GridPane();
    VBox root = new VBox(10, radioBox);

    int count = Stream.of(modes).mapToInt(Mode::getCount).max().orElse(0);
    ObservableMap<Integer, String> elements = FXCollections.observableHashMap();

    ObservableList<String> options = FXCollections.observableArrayList(
            "ciao",
            "hello",
            "halo");

    CheckBox[] checkBoxes = new CheckBox[count];

    elementCount.addListener((o, oldValue, newValue) -> {
        // uncheck checkboxes, if too many are checked
        updateCheckBoxes(checkBoxes, newValue.intValue(), -1);
    });

    for (int i = 0; i < count; i++) {
        final Integer index = i;
        CheckBox checkBox = new CheckBox();
        checkBoxes[i] = checkBox;

        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.valueProperty().addListener((o, oldValue, newValue) -> {
            // modify value in map on value change
            elements.put(index, newValue);
        });
        comboBox.setDisable(true);

        checkBox.selectedProperty().addListener((o, oldValue, newValue) -> {
            comboBox.setDisable(!newValue);
            if (newValue) {
                // put the current element in the map
                elements.put(index, comboBox.getValue());

                // uncheck checkboxes that exceede the required count keeping the current one unmodified
                updateCheckBoxes(checkBoxes, elementCount.get(), index);
            } else {
                elements.remove(index);
            }

        });
        grid.addRow(i, comboBox, checkBox);
    }

    Button submit = new Button("submit");
    submit.setOnAction(evt -> System.out.println(elements));

    // enable submit button iff the number of elements is correct
    submit.disableProperty().bind(elementCount.isNotEqualTo(Bindings.size(elements)));

    root.getChildren().addAll(grid, submit);

    final Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}