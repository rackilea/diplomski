@RestController
public class MercedesController extends BaseCarController{

    private MercedesService mercedesService;

    // Spring will autowire this by default, no need to add @Autowired
    public MercedesController(MercedesService mercedesService) {
        this.mercedesService = mercedesService;
    }

    @GetMapping
    @RequestMapping("Mercedes/cancelOrder")
    public String cancelOrder() {
        return "Cancel order for Mercedes.";
    }
}

@RestController
public class AudiController extends BaseCarController{
    private AudiService audiService;

    // Spring will autowire this by default, no need to add @Autowired
    public AudiController(AudiService audiService) {
        this.audiService = audiService;
    }

    @GetMapping
    @RequestMapping("Audi/cancelOrder")
    public String cancelOrder() {
        return "Cancel order for Audi.";
    }
}