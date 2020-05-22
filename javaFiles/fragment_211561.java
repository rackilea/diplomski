import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SudokuController {


    @FXML
    private ColorPicker colorPicker ;
    @FXML
    private GridPane grid ;
    @FXML
    private BlockController block0Controller ;
    @FXML
    private BlockController block1Controller ;
    @FXML
    private BlockController block2Controller ;
    @FXML
    private BlockController block3Controller ;
    @FXML
    private BlockController block4Controller ;
    @FXML
    private BlockController block5Controller ;
    @FXML
    private BlockController block6Controller ;
    @FXML
    private BlockController block7Controller ;
    @FXML
    private BlockController block8Controller ;

    private BlockController[][] blocks ;

    public void initialize() {
        blocks = new BlockController[][] {
            { block0Controller, block1Controller, block2Controller },
            { block3Controller, block4Controller, block5Controller },
            { block6Controller, block7Controller, block8Controller }            
        };

        for (int blockColumn = 0 ; blockColumn < 3 ; blockColumn++) {
            for (int blockRow = 0 ; blockRow < 3 ; blockRow++) {

                for (int columnInBlock = 0 ; columnInBlock < 3 ; columnInBlock++) {
                    for (int rowInBlock = 0 ; rowInBlock < 3 ; rowInBlock++) {

                        int column = blockColumn * 3 + columnInBlock ;
                        int row = blockRow * 3 + rowInBlock ;

                        String text = String.format("[%d, %d]", column, row);

                        blocks[blockColumn][blockRow].setButtonText(columnInBlock, rowInBlock, text);

                    }
                }

            }
        }
    }

    @FXML
    private void changeColor() {
        Color color = colorPicker.getValue();
        int r = (int) (255 * color.getRed());
        int g = (int) (255 * color.getGreen());
        int b = (int) (255 * color.getBlue());
        String formattedColor = String.format("#%02x%02x%02x", r, g, b);
        grid.setStyle("-sudoku-button-color: "+formattedColor+";");


    }
}