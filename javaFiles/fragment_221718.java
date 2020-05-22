public class DepositController extends Controller implements Initializable {
    AccountController backtoscene;
    @FXML private Label info;
    @FXML private Button btn_depositfinal;
    @FXML private TextField depositamount;
    @FXML private Button btn_back;

    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    }
    public void setAccountController(AccountController controller){
        backtoscene = controller;
    }

    @FXML
    public void handleDepositFinal(ActionEvent event) {
        deposit(Integer.parseInt(depositamount.getText()));
        info.setVisible(true);
    }

    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        backtoscene.updateBal();
        mainStage.setScene(newscene);

    }
}