import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Optional;

public class ComboApp extends Application {
    private Label orderNumber = new Label();
    private Label customerName = new Label();
    private ComboBox<OrderStatusModel> orderStatus = new ComboBox<>();

    private Database database = new InMemoryTestDatabase();

    @Override
    public void start(Stage stage) throws Exception {
        HBox layout = new HBox(
                10, 
                orderNumber, 
                customerName, 
                orderStatus
        );
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.BASELINE_LEFT);

        populateOrderStatusCombobox();
        showOrder(123);
        updateOrderWhenStatusChanged();

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private void updateOrderWhenStatusChanged() {
        orderStatus.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.equals(oldValue)) {
                database.updateOrder(
                        new OrderModel(
                                Integer.parseInt(orderNumber.getText()),
                                customerName.getText(),
                                orderStatus.getValue()
                        )
                );

                System.out.println(
                        "Updated order status of order "
                                + orderNumber.getText()
                                + " to "
                                + orderStatus.getValue()
                                    .orderStatusNameProperty()
                                    .getValue()
                );
            }
        });
    }

    private void populateOrderStatusCombobox(){
        orderStatus.setPlaceholder(new Label("None Selected"));
        orderStatus.getItems().setAll(database.listAllOrderStatuses());

        orderStatus.setConverter(new StringConverter<OrderStatusModel>() {
            @Override
            public String toString(OrderStatusModel orderStatusModel) {
                return orderStatusModel.orderStatusNameProperty().get();
            }

            @Override
            public OrderStatusModel fromString(String orderStatusName) {
                Optional<OrderStatusModel> result = database.findOrderStatusWithName(
                        orderStatusName
                );

                return result.orElse(null);
            }
        });
    }

    private void showOrder(int orderId){
        Optional<OrderModel> result = database.findOrderById(orderId);

        if (!result.isPresent()) {
            orderNumber.setText("");
            customerName.setText("");
            orderStatus.setValue(null);

            return;
        }

        OrderModel order = result.get();

        orderNumber.setText("" + order.orderNumberProperty().get());
        customerName.setText(order.customerNameProperty().get());
        orderStatus.setValue(order.orderStatusProperty().get());
    }

    public static void main(String[] args) {
        launch(args);
    }
}