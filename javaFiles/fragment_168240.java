import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class Controller implements Initializable{

    @FXML
    private Pane pnl_GraphicCard,pnl_Processors,pnl_All;

    @FXML
    private ToggleButton btn_GraphicCard,btn_Processors,btn_All;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ToggleGroup bg = new ToggleGroup();
        bg.getToggles().addAll( btn_GraphicCard,btn_Processors,btn_All);
    }

    @FXML
    void buttonClicked(ActionEvent event) {
        if(event.getSource() == btn_All) {
            pnl_All.toFront();
        }
        else if(event.getSource() == btn_GraphicCard) {
            pnl_GraphicCard.toFront();
        }
        else if(event.getSource() == btn_Processors){
            pnl_Processors.toFront();
        }
    }
}