public class Order {
    private Integer productId;
    private Integer amount;
}

@PUT
@Path("/{productId}/orders")
@Produces("text/plain")
public String updateOrder(@PathParam("productId"), Order order) { ... }