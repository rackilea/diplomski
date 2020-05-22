@Component
public class CircuitBreakerRegistry {

    private static final Map<String, CircuitBreaker> concurrentBreakerMap = new ConcurrentHashMap<String, CircuitBreaker>();
 //More code here...
}