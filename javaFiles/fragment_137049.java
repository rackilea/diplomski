public class OrderConverter extends AbstractConverter<Order> {
     protected Comment createComment(Order order) {
           return new Comment(order.getRemark());
     }
}

public class RequestConverter extends AbstractConverter<Request> {
     protected Comment createComment(Request request) {
           return new Comment(request.getRequestRemark());
     }
}