package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller {
  @FXML
  VBox vBox;

  private final int BUTTONS_NUMBER_OF_ROWS = 5;
  private final int BUTTONS_NUMBER_OF_COLUMNS = 5;
  private Button [][] buttons = new Button[BUTTONS_NUMBER_OF_ROWS][BUTTONS_NUMBER_OF_COLUMNS];


  @FXML
  private void initialize() {
    initializeButtonsArray();
    putButtonsOnGrid();
  }

  private void initializeButtonsArray() {
    for (int i = 0 ; i < BUTTONS_NUMBER_OF_COLUMNS ; i++) {
      for (int j = 0 ; j < BUTTONS_NUMBER_OF_ROWS ; j++) {
        buttons[i][j] = new Button("Button_" + i + j);
      }
    }
  }

  private void putButtonsOnGrid() {
    GridPane buttonsGridPane = new GridPane();
    for (int i = 0 ; i < BUTTONS_NUMBER_OF_COLUMNS ; i++) {
      for (int j = 0 ; j < BUTTONS_NUMBER_OF_ROWS ; j++) {
        buttonsGridPane.add(buttons[i][j], i, j);
      }
    }
    vBox.getChildren().add(buttonsGridPane);
  }
}