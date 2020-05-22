@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @GetMapping
    public Iterable<Vehicle> index(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "25") int per
    ) {
        ...
    }

    ...
}