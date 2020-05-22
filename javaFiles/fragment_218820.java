@RestController
public class IndexController {
    private final Scoper scoper;

    public IndexController(Scoper scoper) {
        this.scoper = scoper;
    }

    @GetMapping("/")
    public String indexAction(Scoper scoper) {
        return String.valueOf(scoper.getNumber(50));
    }
}