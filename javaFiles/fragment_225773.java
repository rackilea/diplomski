public class MainController {
    private static final int COLUMNS  = 4;
    private static final int COUNT    = 12;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;
    private static final int WIDTH    = 130;
    private static final int HEIGHT   = 130;
    @FXML private ImageView loginAnimationImageView;
    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Button loginButton;

    @FXML protected void onEnterTextFieldAction(ActionEvent actionEvent) {
}

    @FXML protected void onEnterPasswordFieldAction(ActionEvent actionEvent) {
}

    @FXML protected void loginButtonAction(ActionEvent actionEvent) {
        final Animation animation = new SpriteAnimation(
                loginAnimationImageView,
                Duration.millis(400.0),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );

        animation.setCycleCount(1);
        animation.play();
    }
}