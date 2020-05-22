@RestController
@RequestMapping("/marketData")
public class MarketDataService {

    @Autowired
    private MarketDataRepository marketDataRepository;

    @PostMapping("")
    public String createMarketData() {
        // ...
    }

    @GetMapping("")
    public String getAllMarketData() {
        // ...
    }

    @GetMapping("/{id}")
    public String getMarketDataById(@PathVariable Long id) {
        // ...
    }

    @DeleteMapping("")
    public String deleteAllMarketData() {
        // ...
    }

    @DeleteMapping("/{id}")
    public String deleteMarketDataById(@PathVariable Long id) {
        // ...
    }

    // ...

}