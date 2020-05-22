import javafx.beans.property.*;

public class OrderModel {

    private final IntegerProperty orderNumber;
    private final StringProperty customerName;
    private final ObjectProperty<OrderStatusModel> orderStatus;

    public OrderModel(int orderNumber, String customerName, OrderStatusModel orderStatus){
        this.orderNumber = new SimpleIntegerProperty(orderNumber);
        this.customerName = new SimpleStringProperty(customerName);
        this.orderStatus = new SimpleObjectProperty<>(orderStatus);
    }

    public IntegerProperty orderNumberProperty() {
        return orderNumber;
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public ObjectProperty<OrderStatusModel> orderStatusProperty() {
        return orderStatus;
    }
}