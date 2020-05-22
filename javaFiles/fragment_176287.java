public static class Item {

    private final IntegerProperty itemCount = new SimpleIntegerProperty();
    private final IntegerProperty itemMaxCount = new SimpleIntegerProperty();

    @Override
    public String toString() {
        return Integer.toString(getItemCount());
    }

    public Item(int disp, int max) {
        this.itemCount.setValue(disp);
        this.itemMaxCount.setValue(max);
    }

    public final int getItemCount() {
        return this.itemCount.get();
    }

    public final void setItemCount(int value) {
        this.itemCount.set(value);
    }

    public final IntegerProperty itemCountProperty() {
        return this.itemCount;
    }

    public final int getItemMaxCount() {
        return this.itemMaxCount.get();
    }

    public final void setItemMaxCount(int value) {
        this.itemMaxCount.set(value);
    }

    public final IntegerProperty itemMaxCountProperty() {
        return this.itemMaxCount;
    }

}

@Override
public void start(Stage primaryStage) {
    TableView<Item> tv = new TableView<>(FXCollections.observableArrayList(
            new Item(1, 10),
            new Item(0, 9),
            new Item(1, 8),
            new Item(0, 7),
            new Item(1, 42),
            new Item(0, 4),
            new Item(1, 2),
            new Item(0, 99),
            new Item(1, 77),
            new Item(0, 44),
            new Item(1, 11),
            new Item(0, 2),
            new Item(1, 2),
            new Item(0, 3),
            new Item(1, 5),
            new Item(0, 6)
    ));

    TableColumn<Item, Item> countColumn = new TableColumn<>("count");
    countColumn.setCellValueFactory(cd -> Bindings.createObjectBinding(() -> cd.getValue()));

    countColumn.setCellFactory(new Callback<TableColumn<Item, Item>, TableCell<Item, Item>>() {
        @Override
        public TableCell<Item, Item> call(TableColumn<Item, Item> param) {
            TableCell<Item, Item> cell = new TableCell<Item, Item>() {

                private final Spinner<Integer> count;

                private final SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory;
                private final ChangeListener<Number> valueChangeListener;

                {
                    valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0);
                    count = new Spinner<>(valueFactory);
                    count.setVisible(false);
                    setGraphic(count);
                    valueChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                        valueFactory.setValue(newValue.intValue());
                    };
                    count.valueProperty().addListener((obs, oldValue, newValue) -> {
                        if (getItem() != null) {
                            // write new value to table item
                            getItem().setItemCount(newValue);
                        }
                    });
                }

                @Override
                public void updateItem(Item item, boolean empty) {

                    // unbind old values
                    valueFactory.maxProperty().unbind();
                    if (getItem() != null) {
                        getItem().itemCountProperty().removeListener(valueChangeListener);
                    }

                    super.updateItem(item, empty);

                    // update according to new item
                    if (empty || item == null) {
                        count.setVisible(false);
                    } else {
                        valueFactory.maxProperty().bind(item.itemMaxCountProperty());
                        valueFactory.setValue(item.getItemCount());
                        item.itemCountProperty().addListener(valueChangeListener);
                        count.setVisible(true);
                    }

                }
            };

            return cell;
        }
    });

    tv.getColumns().add(countColumn);

    Button btn = new Button("Print");
    btn.setOnAction((ActionEvent event) -> {
        System.out.println(tv.getItems());
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(new VBox(10, tv, btn));

    primaryStage.setScene(scene);
    primaryStage.show();
}