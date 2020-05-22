@Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Hover over me.'");

        btn.hoverProperty().addListener((event)->System.out.println("Ho-Ho-Ho-Hovereeed!"));        

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Mouse manpulation example in JavaFX!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }