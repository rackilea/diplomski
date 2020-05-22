public class CardController extends Pane {
 private final Card card;
 CardController(Card card) {
   this.card = card;
   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CardView.fxml"));
   fxmlLoader.setController(this);
   fxmlLoader.setRoot(this);
   fxmlLoader.load();
 }
}