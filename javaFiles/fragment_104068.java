private static ComboBox<String> createCombo(double x, double y, double width) {
    ComboBox<String> comboBox = new ComboBox<>();
    comboBox.setLayoutX(x);
    comboBox.setLayoutY(y);
    comboBox.setMaxWidth(Region.USE_PREF_SIZE);
    comboBox.setMinWidth(Region.USE_PREF_SIZE);
    comboBox.setPrefWidth(width);

    return comboBox;
}

private static Label createLabel(String text, double maxWidth) {
    Label label = new Label(text);
    label.setMaxWidth(maxWidth);
    return label;
}

@Override
public void start(Stage primaryStage) {
    String[] teams = new String[64];
    for (int i = 0; i < teams.length; i++) {
        teams[i] = Integer.toString(i);
    }
    final double offsetY = 30;
    final double offsetX = 100;
    final double width = 90;

    Pane root = new Pane();

    // array storing the comboboxes
    // combos for previous round are at the lowest indices
    ComboBox<String>[] combos = new ComboBox[teams.length / 2];

    // create initial team labels & comboboxes
    for (int i = 0, offsetTeams = 0; i < combos.length; i++, offsetTeams += 2) {
        Label label = createLabel(teams[offsetTeams], width);
        double y = offsetTeams * offsetY;
        label.setLayoutY(y);
        root.getChildren().add(label);

        label = createLabel(teams[offsetTeams+1], width);
        label.setLayoutY(y+offsetY);

        ComboBox<String> comboBox = createCombo(offsetX, y + offsetY / 2, width);
        comboBox.getItems().addAll(teams[offsetTeams], teams[offsetTeams+1]);
        combos[i] = comboBox;

        root.getChildren().addAll(label, comboBox);
    }

    double x = 2 * offsetX;
    int count = combos.length / 2; // combos still left for the next round

    for (; count > 0; count /= 2, x += offsetX) { // for each round
        // create comboboxes combining the combos from previous round pairwise
        for (int i = 0, ci = 0; i < count; i++, ci+=2) {
            // get combos pairwise
            ComboBox<String> c1 = combos[ci];
            ComboBox<String> c2 = combos[ci+1];

            ComboBox<String> combo = createCombo(x, (c1.getLayoutY() + c2.getLayoutY()) / 2, width) ;

            // combine data from previous round
            ChangeListener<String> listener = (o, oldValue, newValue) -> {
                final List<String> items = combo.getItems();
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

            root.getChildren().add(combo);
            combos[i] = combo;
        }
    }

    primaryStage.setScene(new Scene(new ScrollPane(root), 600, 400));
    primaryStage.show(); 
}