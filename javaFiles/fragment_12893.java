import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableEdit extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Order> tv = new TableView<>();
        ObservableList<Order> items = FXCollections.observableArrayList(
                new Order("a-12", 100), new Order("b-23", 200), new Order("c-34", 300));
        tv.setItems(items);

        TableColumn<Order, String> tcNum = new TableColumn("Order#");
        tcNum.setPrefWidth(100);
        TableColumn<Order, Number> tcQty = new TableColumn("Qty");
        tcQty.setPrefWidth(100);
        tcNum.setCellValueFactory(new PropertyValueFactory<>("orderNum"));
        tcQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tv.getColumns().addAll(tcNum, tcQty);

        HBox hbox = new HBox();
        TextField orderNum = new TextField();
        orderNum.setPrefWidth(100);
        TextField qty = new TextField();
        qty.setPrefWidth(100);

        tv.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
            if (nv != null) {
                orderNum.setText(nv.orderNum.get());
                qty.setText(String.valueOf(nv.qty.get()));
            }
        });

        Button commit = new Button("Commit");
        commit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt) {
                Order item = tv.getSelectionModel().getSelectedItem();
                item.orderNum.set(orderNum.getText());
                item.qty.set(Integer.valueOf(qty.getText()));
                tv.toFront();
            }
        });

        hbox.getChildren().addAll(orderNum, qty, commit);
        StackPane root = new StackPane(hbox, tv);

        tv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                if (evt.getClickCount()==2){
                    StackPane.setMargin(hbox, new Insets(evt.getSceneY(), 0, 0, 0));
                    hbox.toFront();
                }
            }
        });

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public class Order {

        private final SimpleStringProperty orderNum = new SimpleStringProperty();
        private final SimpleIntegerProperty qty = new SimpleIntegerProperty();

        public SimpleStringProperty orderNumProperty() {return orderNum;}
        public SimpleIntegerProperty qtyProperty() {return qty;}

        public Order(String orderNum, int qty) {
            this.orderNum.set(orderNum);
            this.qty.set(qty);
        }
    }
}