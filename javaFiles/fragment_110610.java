@Component
public class SceneController implements Initializable {
   @FXML
   private Label label;

   @FXML
   private void buttonAction(){
        label.setText("Hello World!");
   }

   @Override
   public void initialize(URL url, ResourceBundle rb) {
         // TODO
   }

}