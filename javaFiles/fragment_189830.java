import java.util.List;
import java.util.Optional;

public interface Database {
    List<OrderStatusModel> listAllOrderStatuses();
    Optional<OrderStatusModel> findOrderStatusWithName(String orderStatusName);
    Optional<OrderStatusModel> findOrderStatusById(int orderStatusId);
    Optional<OrderModel> findOrderById(int orderId);
    void updateOrder(OrderModel order);
}