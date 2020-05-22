@Override
public void updateItem(ObservableList<Foo2> item, boolean empty) {
    super.updateItem(item, empty);
    if (empty || item == null) {
        setText(null);
        setTooltip(null);
    } else {
        GridPane grid = new GridPane();
        int modulus;
        if (item.size() < 4) {
            modulus = 1;
        }
        else if (item.size() < 9) {
            modulus = 2;
        }
        else {
            modulus = 3;
        }
        for (int i = 0; i < item.size(); ++i) {
            Label label = new Label();
            label.setText(item.get(i).toString());
            grid.add(label, i % modulus, (i % item.size()) / modulus);
        }
        item.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                updateItem(item, empty);
            }
        });
        setGraphic(grid);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
}