public class MyController {
    @FXML private ImageView hand;

    private void updateStopwatch(){
        elapsedTime++;
        Integer rotation = elapsedTime * 6;
        hand.setRotate(rotation);      
    }
}