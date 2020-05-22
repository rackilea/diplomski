public void start(Stage primaryStage) {

    ListView<Tree> simpleList = new ListView<>(FXCollections.observableArrayList(new Tree(0, "add new tree here"), new Tree(1, "Tree one"), new Tree(2, "Tree two"), new Tree(1, "Tree three"), new Tree(1, "Tree four"), new Tree(1, "Tree five")));
    simpleList.setEditable(true);

    simpleList.setCellFactory(listView -> {
        TextFieldListCell<Tree> cell = new TextFieldListCell<>();
        cell.setConverter(new StringConverter<Tree>() {
            @Override
            public String toString(Tree tree) {
                return tree.getName();
            }

            @Override
            public Tree fromString(String string) {
                Tree tree = cell.getItem();
                tree.setName(string);
                return tree;
            }
        });
        return cell;
    });

    simpleList.setOnEditCommit(t -> {
        simpleList.getItems().set(t.getIndex(), t.getNewValue());
        if (t.getIndex() == 0) {
            simpleList.getItems().add(0, new Tree(0, "add new tree here"));
        }
    });

    // init delete item handler
    simpleList.setOnKeyReleased(event -> {
        if (event.getCode().equals(KeyCode.DELETE)) {
            Tree selectedItem = simpleList.getSelectionModel().getSelectedItem();
            simpleList.getItems().remove(selectedItem);
            System.out.println(selectedItem + " deleted from list");
        }
    });

    simpleList.setOnEditCancel(t -> System.out.println("setOnEditCancel"));

    BorderPane root = new BorderPane();
    root.setCenter(simpleList);
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}