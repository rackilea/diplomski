@RestController
@RequestMapping(path = "/users")
public class UserController {

    @GetMapping("/{user_id}")
    public User getUserById(@PathVariable("user_id") String userId) { }

    @GetMapping("/{user_id}/orders")
    public List<Order> getOrdersByUserId(@PathVariable("user_id") String userId) { }

     @GetMapping("/{user_id}/orders/{order_id}")
    public List<Order> getOrdersByIdAndUserId(@PathVariable("user_id") String userId, @PathVariable("order_id") String orderId) { }

    // ... and so on
}