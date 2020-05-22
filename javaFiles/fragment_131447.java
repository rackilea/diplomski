public class ReplaceController {
    @FXML
    private Region r1;
    @FXML
    private Region r2;
    @FXML
    private Region r0;
    @FXML
    private Pane stackConsole;

    @FXML
    private void btn0(ActionEvent event) {
        stackConsole.getChildren().setAll(r0);
    }

    @FXML
    private void btn1(ActionEvent event) {
        stackConsole.getChildren().setAll(r1);
    }

    @FXML
    private void btn2(ActionEvent event) {
        stackConsole.getChildren().setAll(r2);
    }

}