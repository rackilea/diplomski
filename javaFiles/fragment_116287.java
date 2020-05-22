/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package row;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Electron
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Button> buttons;
    @FXML
    private TableColumn<Button, String> name;
    @FXML
    private TableColumn<Button, String> color;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populate();
        styleRowColor();
    }

    private void styleRowColor() {
        Callback<TableColumn<Button, String>, TableCell<Button, String>> cellFactory
                = //
                new Callback<TableColumn<Button, String>, TableCell<Button, String>>() {
            @Override
            public TableCell<Button, String> call(final TableColumn<Button, String> param) {
                final TableCell<Button, String> cell = new TableCell<Button, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            setText(item);
                            TableRow<Button> row = getTableRow();
                            if (row.getItem().getColor().equals("red")) {
                                row.getStyleClass().clear();
                                row.getStyleClass().add("red-row");
                            }
                            if (row.getItem().getColor().equals("orange")) {
                                row.getStyleClass().clear();
                                row.getStyleClass().add("orange-row");
                            }
                            if (row.getItem().getColor().equals("green")) {
                                row.getStyleClass().clear();
                                row.getStyleClass().add("green-row");
                            }
                            if (row.getItem().getColor().equals("yellow")) {
                                row.getStyleClass().clear();
                                row.getStyleClass().add("yellow-row");
                            }
                        }
                    }
                };
                return cell;
            }
        };
        color.setCellFactory(cellFactory);

    }

    private void populate() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));

        Button button = new Button("btn1", "red");
        Button button2 = new Button("btn2", "green");
        Button button3 = new Button("btn3", "yellow");
        Button button4 = new Button("btn4", "orange");
        buttons.getItems().addAll(button, button2, button3, button4);
    }
}