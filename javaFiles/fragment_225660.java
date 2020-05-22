@RestController
@RequestMapping("/api/cars/")
public class MyController {

    @GetMapping
    @RequestMapping("{producer}/cancelOrder")
    public String cancelOrder(@PathVariable String producer) {
        return "Cancel order for " + producer;
    }
}