public class CustomTree extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TreeView<String[]> tree = new TreeView<>();

        tree.setCellFactory(cell -> new TreeCell<String[]>() {

            private GridPane pane = new GridPane();
            private Label keyLabel = new Label();
            private Label valueLabel = new Label();
            private Border keyBorder = new Border(
                    new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.5, 0.5, 0.5, 1)));
            private Border valueBorder = new Border(
                    new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.5, 1, 0.5, 0.5)));

            {
                pane.getChildren().addAll(keyLabel, valueLabel);
                GridPane.setConstraints(keyLabel, 0, 0);
                GridPane.setConstraints(valueLabel, 1, 0);

                ColumnConstraints column1 = new ColumnConstraints();
                column1.setPercentWidth(50);
                ColumnConstraints column2 = new ColumnConstraints();
                column2.setPercentWidth(50);
                pane.getColumnConstraints().addAll(column1, column2);

                keyLabel.setBorder(keyBorder);
                valueLabel.setBorder(valueBorder);
                keyLabel.setMaxWidth(Double.MAX_VALUE);
                valueLabel.setMaxWidth(Double.MAX_VALUE);

                setPadding(Insets.EMPTY);
            }

            @Override
            public void updateItem(String[] name, boolean empty) {
                super.updateItem(name, empty);
                if (empty || name == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    keyLabel.setText(name[0]);
                    valueLabel.setText(name[1]);
                    setGraphic(pane);
                }
            }
        });

        TreeItem<String[]> root = new TreeItem<>(new String[] { "", "" });
        TreeItem<String[]> sub1 = new TreeItem<>(new String[] { "Foo", "Bar" });
        TreeItem<String[]> sub2 = new TreeItem<>(new String[] { "Foo", "Bar" });
        TreeItem<String[]> sub3 = new TreeItem<>(new String[] { "Foo", "Bar" });
        TreeItem<String[]> sub4 = new TreeItem<>(new String[] { "Foo", "" });
        TreeItem<String[]> sub5 = new TreeItem<>(new String[] { "Foo", "Bar" });
        TreeItem<String[]> sub41 = new TreeItem<>(new String[] { "Foo", "Bar" });
        TreeItem<String[]> sub42 = new TreeItem<>(new String[] { "Foo", "Bar" });
        root.getChildren().addAll(sub1, sub2, sub3, sub4, sub5);
        sub4.getChildren().addAll(sub41, sub42);

        tree.setRoot(root);

        Scene scene = new Scene(tree);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}