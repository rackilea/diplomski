import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BlockController {

    @FXML
    private Button button0 ;
    @FXML
    private Button button1 ;
    @FXML
    private Button button2 ;
    @FXML
    private Button button3 ;
    @FXML
    private Button button4 ;
    @FXML
    private Button button5 ;
    @FXML
    private Button button6 ;
    @FXML
    private Button button7 ;
    @FXML
    private Button button8 ;

    private Button[][] buttons ;

    public void initialize() {
        buttons = new Button[][]{
                { button0, button1, button2 },
                { button3, button4, button5 },
                { button6, button7, button8 }
        };
        for (Button[] buttonRow : buttons) {
            for (Button button : buttonRow) {
                GridPane.setFillHeight(button, true);
                GridPane.setFillWidth(button, true);
            }
        }
    }

    public void setButtonText(int column, int row, String text) {
        buttons[column][row].setText(text);
    }
}