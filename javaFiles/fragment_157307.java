public class PopupController {

    @FXML
    private Button confirmPop ;

    private boolean confirmed = false ;

    public void isConfirmed() {
        return confirmed ;
    }

    @FXML
    private void confirmPop() {
        confirmed = true ;
        confirmPop.getScene().getWindow().hide();
    }

    @FXML
    private void cancelPop() {
        confirmed = false ;
        confirmPop.getScene().getWindow().hide();
    }
}