@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "countries")
public class UserLimitReader{
    private Map<String, Integer> orders = new HashMap<>();

    private Map<String, Integer> requests = new HashMap<>();

    public Map<String, Integer> getOrders() {
        return orders;
    }
    ...
}