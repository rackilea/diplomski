private boolean isANext = true;

public void start(Stage primaryStage) throws Exception {
    Button button = new Button("Change CSS");
    VBox vbox = new VBox(10);
    vbox.setAlignment(Pos.CENTER);
    vbox.getChildren().add(button);
    scene = new Scene(vbox, 200, 200);

    button.setOnAction(ev -> {
        // Alternate two stylesheets just for this demo.
        String css = isANext ? "file:///C:/temp/a.css" : "file:///C:/temp/b.css";
        isANext = !isANext;
        System.out.println("Loading CSS at URL " + css);

        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);
    });

    primaryStage.setTitle("Title");
    primaryStage.setScene(scene);
    primaryStage.show();
}