final StackPane sp = new StackPane();
final PasswordField pwf = new PasswordField();
final TextField tf = new TextField();
final ToggleButton toggle = new ToggleButton();

sp.getChildren().addAll(pwf, tf);

pwf.textProperty().bindBidirectional(tf.textProperty());
pwf.visibleProperty().bind(toggle.selectedProperty().not());
tf.visibleProperty().bind(toggle.selectedProperty());