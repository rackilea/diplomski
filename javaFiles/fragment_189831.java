import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTestDatabase implements Database {
    List<OrderStatusModel> orderStatuses = new ArrayList<>();
    List<OrderModel> orders = new ArrayList<>();

    public InMemoryTestDatabase() {
        // populate with dummy sample data.
        orderStatuses.add(new OrderStatusModel(1, "Order Taken"));
        orderStatuses.add(new OrderStatusModel(2, "Order Processing"));
        orderStatuses.add(new OrderStatusModel(3, "Shipped"));

        orders.add(
                new OrderModel(
                        123,
                        "XYZZY",
                        findOrderStatusById(1)
                                .orElse(null)
                )
        );
    }

    public List<OrderStatusModel> listAllOrderStatuses() {
        return orderStatuses;
    }

    @Override
    public Optional<OrderStatusModel> findOrderStatusWithName(String orderStatusName) {
        return orderStatuses.stream()
                .filter(orderStatus -> orderStatusName.equals(orderStatus.orderStatusNameProperty().get()))
                .findFirst();
    }

    @Override
    public Optional<OrderStatusModel> findOrderStatusById(int orderStatusId) {
        return orderStatuses.stream()
                .filter(orderStatus -> orderStatusId == orderStatus.orderStatusIdProperty().get())
                .findFirst();
    }

    public Optional<OrderModel> findOrderById(int orderId) {
        return orders.stream()
                .filter(order -> orderId == order.orderNumberProperty().get())
                .findFirst();
    }

    public void updateOrder(OrderModel order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).orderNumberProperty().get() == order.orderNumberProperty().get()) {
                orders.set(i, order);
                break;
            }
        }
    }
}