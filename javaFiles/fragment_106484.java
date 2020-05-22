public class RadioButtonListView extends Application {

    public static final ObservableList names =
            FXCollections.observableArrayList();
    private ToggleGroup group = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List View Sample");

        final ListView listView = new ListView();
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        names.addAll(
                "Adam", "Alex", "Alfred", "Albert",
                "Brenda", "Connie", "Derek", "Donny",
                "Lynne", "Myrtle", "Rose", "Rudolph",
                "Tony", "Trudy", "Williams", "Zach"
        );

        listView.setItems(names);
        listView.setCellFactory(param -> new RadioListCell());

        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class RadioListCell extends ListCell<String> {

        RadioButton radioButton;
        ChangeListener<Boolean> radioListener = (src, ov, nv) -> radioChanged(nv);
        WeakChangeListener<Boolean> weakRadioListener = new WeakChangeListener(radioListener);

        public RadioListCell() {
            radioButton = new RadioButton();
            radioButton.selectedProperty().addListener(weakRadioListener);
            radioButton.setFocusTraversable(false);
            // let it span the complete width of the list
            // needed in fx8 to update selection state
            radioButton.setMaxWidth(Double.MAX_VALUE);
        }

        protected void radioChanged(boolean selected) {
            if (selected && getListView() != null && !isEmpty() && getIndex() >= 0) {
                getListView().getSelectionModel().select(getIndex());
            }
        }

        @Override
        public void updateItem(String obj, boolean empty) {
            super.updateItem(obj, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
                radioButton.setToggleGroup(null);
            } else {
                radioButton.setText(obj);
                radioButton.setToggleGroup(group);
                radioButton.setSelected(isSelected());
                setGraphic(radioButton);
            }
        }
    }
}