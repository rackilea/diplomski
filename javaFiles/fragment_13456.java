@RestController
public class MyRestController {

    @PostMapping("/orders")
    public void createOrders(@RequestBody List<Order> orders) {
        // manipulations with orders
    }
}