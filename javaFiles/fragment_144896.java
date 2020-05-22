import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.geometry.Insets;
import javafx.collections.*;
import java.util.*;
import javafx.beans.property.*;
public class TableCheckboxesExample extends Application {
    @Override public void start(Stage primaryStage) {
        TableView<Pizza> table = new TableView<>();
        table.setEditable(true);
        table.setItems(getDataRoutine());
        TableColumn<Pizza, String> titleCol = new TableColumn<Pizza, String>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<Pizza, String>("title"));
        TableColumn<Pizza, Boolean> meatCol = new TableColumn<Pizza, Boolean>("Meat");
        meatCol.setEditable(true);
        meatCol.setCellValueFactory(new PropertyValueFactory<Pizza, Boolean>("meat"));
        meatCol.setCellFactory(CheckBoxTableCell.forTableColumn(meatCol));
        TableColumn<Pizza, Boolean> vegCol = new TableColumn<Pizza, Boolean>("Veg");
        vegCol.setEditable(true);
        vegCol.setCellValueFactory(new PropertyValueFactory<Pizza, Boolean>("veg"));
        vegCol.setCellFactory(CheckBoxTableCell.forTableColumn(vegCol));
        table.getColumns().addAll(titleCol, meatCol, vegCol);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(table);
        Scene scene = new Scene(vbox, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza table with checkboxes");
        primaryStage.show();
        table.getSelectionModel().select(0);
    }

    private ObservableList<Pizza> getDataRoutine() {
        List<Pizza> pizzas = Arrays.asList(new Pizza("Meat lover"),
                new Pizza("Veggie lover"), new Pizza("Meditarranean"),
                new Pizza("Italian"));
        ObservableList<Pizza> data = FXCollections.observableArrayList();
        data.addAll(pizzas);
        // Add listeners to boolean properties
        for (Pizza pizza : data) {
            pizza.meatProperty().addListener((obs, wasSelected, isSelected) -> {
                pizza.setVeg(wasSelected);
            });
            pizza.vegProperty().addListener((obs, wasSelected, isSelected) -> {
                pizza.setMeat(wasSelected);
            });
        }
        return data;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class Pizza {
        private SimpleBooleanProperty veg;
        private SimpleBooleanProperty meat;
        private SimpleStringProperty title;
        public Pizza(String title) {
            this.veg = new SimpleBooleanProperty(false);
            this.meat = new SimpleBooleanProperty(false);
            this.title = new SimpleStringProperty(title);
        }
        public boolean isVeg() {
            return veg.get();
        }
        public void setVeg(boolean value) {
            veg.set(value);
        }
        public SimpleBooleanProperty vegProperty() {
            return veg;
        }
        public boolean isMeat() {
            return meat.get();
        }
        public void setMeat(boolean value) {
            meat.set(value);
        }
        public SimpleBooleanProperty meatProperty() {
            return meat;
        }
        public String getTitle() {
            return title.get();
        }
        public void setTitle(String value) {
            this.title.set(value);
        }
        public SimpleStringProperty titleProperty() {
            return title;
        }
    }
}