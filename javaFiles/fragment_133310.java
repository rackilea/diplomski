public class FXMLDocumentController implements Initializable {

    Movements movements = new Movements();

    public Movements getMovements() {
        return movements;
    }

    @FXML public Slider SpeedSlider;
    @FXML public Slider TurnsSlider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Send GUI Information
        movements.GetSliders(SpeedSlider, TurnsSlider);
    }    

}