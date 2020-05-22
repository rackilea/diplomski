public class HandController extends FlowPane {

 HandController() {
   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HandView.fxml"));
   fxmlLoader.setController(this);
   fxmlLoader.setRoot(this);
   fxmlLoader.load();
 }

 public void setHand(ArrayList<Cards> hand){
    for(int i = 0; i < hand.size(); ++i){
        addCard(hang.get(i));
    }    
 }

 public void addCard(Cards card) {
    getChildren().add(new CardController(card));
 }
}