public class ConditionalBind extends Application {

    Label label = new Label();
    TextField tf = new TextField("hi");
    CheckBox cb = new CheckBox("lowerize");

    @Override
    public void start(Stage primaryStage) {

        label.textProperty().bind(new StringBinding() {

            {
                bind(tf.textProperty(), cb.selectedProperty());
            }

            @Override
            protected String computeValue() {
                return cb.isSelected() ? tf.getText().toLowerCase() : tf.getText();
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(label, cb, tf);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}