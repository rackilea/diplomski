public class Sandbox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.add(new Label("Number field:"), 0 , 0);
        TextField numberField = new TextField("");
        pane.add(numberField, 1, 0);
        TextField textField = new TextField("");
        pane.add(new Label("Text field:"), 0, 1);
        pane.add(textField, 1, 1);

        ValidationSupport vs = new ValidationSupport();
        vs.setErrorDecorationEnabled(false); // we don't want errors to bother us for now.
        vs.registerValidator(numberField, Validator.createRegexValidator("must be digits only!", "\\d*", Severity.ERROR));

        // validate and show errors only if number field has the focus
        vs.errorDecorationEnabledProperty().bind(numberField.focusedProperty());

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Sandbox.class);
    }
}