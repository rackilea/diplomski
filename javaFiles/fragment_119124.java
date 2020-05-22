@RestController
public class MyController {

    @JsonView(OrderViews.AllFields.class)
    @GetMapping("/with-all-fields")
    public Order getOrderAllFields() {
        return orderService.getOrder();
    }

    @JsonView(OrderViews.OnlySomeFields.class)
    @GetMapping("/with-some-fields")
    public Order getOrderAllFields() {
        return orderService.getOrder();
    }

}