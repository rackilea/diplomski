public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final SubPane subPane = new SubPane();

        final TranslateTransition dialogAnimator =
                new TranslateTransition(new Duration(500), subPane);

        final Button showSubPaneButton = new Button("Slide a sub pane");
        showSubPaneButton.setOnAction(event -> {
            dialogAnimator.setToY(10);
            dialogAnimator.play();
        });

        subPane.setCloseAction(event -> {
            dialogAnimator.setToY(-subPane.getHeight());
            dialogAnimator.play();
        });

        final Pane rootPane = new StackPane(showSubPaneButton, subPane);
        rootPane.setPrefWidth(400);
        rootPane.setPrefHeight(300);

        // By default hide the given pane by moving to the top.
        Platform.runLater(() -> subPane.setTranslateY(-subPane.getHeight()));

        primaryStage.setTitle("Drop slided dialog");
        primaryStage.setScene(new Scene(rootPane));
        primaryStage.show();
    }
}

class SubPane extends BorderPane {
    private final Button dialogButton = new Button("Close");

    SubPane() {
        final Pane centralPane = new StackPane(dialogButton);
        centralPane.setStyle(
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);-fx-padding: 10;" +
                "-fx-background-color: firebrick;-fx-background-radius: 10;");
        setCenter(centralPane);

        final Pane blankLeftPane = new StackPane();
        blankLeftPane.setPrefWidth(100);
        setLeft(blankLeftPane);

        final Pane blankRightPane = new StackPane();
        blankRightPane.setPrefWidth(100);
        setRight(blankRightPane);

        final Pane blankBottomPane = new StackPane();
        blankBottomPane.setPrefHeight(200);
        setBottom(blankBottomPane);
    }

    void setCloseAction(final EventHandler<ActionEvent> closeCallback) {
        dialogButton.setOnAction(closeCallback);
    }
}