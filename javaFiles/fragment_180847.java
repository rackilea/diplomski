public class Controller {

   @FXML
   private Text position;

   private final Model model ;

   public Controller(Model model) {
       this.model = model ;
   }

   public void initialize() {
       position.textProperty().bind(model.positionProperty());
   }

   // ...
}