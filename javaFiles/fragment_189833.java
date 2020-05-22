import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class OrderStatusModel {
    private final IntegerProperty orderStatusId;
    private final StringProperty orderStatusName;

    public OrderStatusModel(int orderStatusId, String orderStatusName){
        this.orderStatusId = new SimpleIntegerProperty(orderStatusId);
        this.orderStatusName = new SimpleStringProperty(orderStatusName);
    }

    public IntegerProperty orderStatusIdProperty() {
        return orderStatusId;
    }

    public StringProperty orderStatusNameProperty() {
        return orderStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusModel that = (OrderStatusModel) o;
        return Objects.equals(orderStatusId.get(), that.orderStatusId.get()) &&
                Objects.equals(orderStatusName.get(), that.orderStatusName.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatusId.get(), orderStatusName.get());
    }
}