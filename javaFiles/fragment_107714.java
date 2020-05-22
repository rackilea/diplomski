BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);
        root.setCenter(scrollPane);
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Button("cat"), new Button("dog"));
        root.setBottom(hBox);