public class AccountController extends Controller implements Initializable {

    @FXML private Label gilbert;
    @FXML private Label lbBalance;
    @FXML private Button deposit;
    @FXML private Button btn_showBalance;
    private application.DepositController depositController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbBalance.setText(String.valueOf(BAL));
    }

    @FXML
    public void handleDeposit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Parent depositParent = loader.load();  
        depositScene = new Scene(depositParent);
        depositController = loader.getController();
        depositController .setAccountController(this);

        mainStage.setScene(depositScene);       
        mainStage.show();
    }

    public void updateBal() {
        lbBalance.setText(String.valueOf(BAL));
    }

}