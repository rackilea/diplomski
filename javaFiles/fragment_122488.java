public class ComboBoxActionEditable extends Application{

    ComboBox<String> cb = new ComboBox<>();

    /**
     * Sets the combo's editable if given value equals the marker.
     * @param nv the value to test
     */
    protected void updateEditable(String nv) {
        if ("Other".equals(nv)) {
            cb.setEditable(true);
            FakeFocusTextField textField = (FakeFocusTextField) cb.getEditor();
            textField.requestFocus();
            textField.setFakeFocus(true);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button b = new Button("GOOWE");

        Label choice = new Label("What type of Vehicle do you drive");
        cb.getItems().addAll("Car","Jeep","Bus","Other");

        cb.setPromptText("Select your Vehicle");

        cb.valueProperty().addListener((src, ov, nv) -> {
            // fx8 bug: internals blow up when changing editable while showing
            if (cb.isShowing() || cb.isEditable()) return;
            updateEditable(nv);
        });

        // hack around fx8 bug: 
        cb.setOnHidden(e -> {
            if (cb.isEditable()) return;
            updateEditable(cb.getValue());

        });

        // to see that editable is switched and textField focused
        // when changing the value programmatically
         b.setOnAction(e -> {
             cb.setValue("Other");
         });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(choice,cb,b);
        Scene sc = new Scene(layout,200,400);
        stage.setScene(sc);
        stage.setTitle(FXUtils.version());
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}