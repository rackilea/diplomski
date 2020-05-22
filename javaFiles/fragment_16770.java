@RestController
public class MarketDataService {

    @Autowired
    private MarketDataRepository marketDataRepository;

    @GetMapping("/marketData")
    public String getMarketData() {
        return "foobar";
    }

}