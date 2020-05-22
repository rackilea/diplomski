@Override
public void start(Stage stage) throws Exception {
    stage.setTitle("How to bind tooltip to focus event?");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(5);
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.add(new Label("Email"), 0, 0);
    grid.add(new TextField(), 0, 1);
    grid.add(new Label("Password"), 0, 2);

    final Tooltip tooltip = new Tooltip("Paswords must contain 1-50 characters, etc...");
    tooltip.setWrapText(true);
    tooltip.setTextOverrun(OverrunStyle.ELLIPSIS);
    final PasswordField pf = new PasswordField();
    pf.setPromptText("Password");
    //pf.setTooltip(tooltip);
    pf.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue) {
                tooltip.show(pf, //
                        // popup tooltip on the right, you can adjust these values for different positions
                        pf.getScene().getWindow().getX() + pf.getLayoutX() + pf.getWidth() + 10, //
                        pf.getScene().getWindow().getY() + pf.getLayoutY() + pf.getHeight());
            } else {
                tooltip.hide();
            }
        }
    });
    grid.add(pf, 0, 3);

    stage.setScene(new Scene(grid, 300, 275));
    stage.sizeToScene();
    stage.show();
}