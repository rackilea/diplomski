public class Controller{

   @FXML
   private Text position;

   private Model model ;

   public void initialize() {
       position.textProperty().bind(model.positionProperty());
   }

   // ...
}