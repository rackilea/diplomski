import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    var table = new TableView<Item>();

    for (int i = 1; i <= 25; i++) {
      table.getItems().add(new Item("Item #" + i));
    }

    var selecteAllCheckBox = new CheckBox();
    selecteAllCheckBox.setOnAction(
        event -> {
          event.consume();
          table.getItems().forEach(item -> item.setSelected(selecteAllCheckBox.isSelected()));
        });

    var selectedCol = new TableColumn<Item, Boolean>();
    selectedCol.setGraphic(selecteAllCheckBox);
    selectedCol.setSortable(false);
    selectedCol.setPrefWidth(50);
    selectedCol.setCellValueFactory(data -> data.getValue().selectedProperty());
    selectedCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectedCol));
    table.getColumns().add(selectedCol);

    var nameCol = new TableColumn<Item, String>("Name");
    nameCol.setPrefWidth(550);
    nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
    table.getColumns().add(nameCol);

    primaryStage.setScene(new Scene(table, -1, 400));
    primaryStage.show();
  }

  static class Item {

    // -- PROPERTIES --

    private final BooleanProperty selected = new SimpleBooleanProperty();
    final void setSelected(boolean selected) { this.selected.set(selected); }
    final boolean isSelected() { return selected.get(); }
    final BooleanProperty selectedProperty() { return selected; }

    private final StringProperty name = new SimpleStringProperty();
    final void setName(String name) { this.name.set(name); }
    final String getName() { return name.get(); }
    final StringProperty nameProperty() { return name; }

    // -- CONSTRUCTOR --

    Item(String name) {
      setName(name);
    }
  }
}