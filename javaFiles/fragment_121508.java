public class Application_Controler implements Initializable {

    @FXML
    private TextField txt;

    @FXML
    private TextArea showTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         showTxt.textProperty().bind(txt.textProperty());
    }
}