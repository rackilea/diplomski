@Component
@ConfigurationProperties(prefix="my")
public class FruitConfig {
    private final List<String> fruits = new ArrayList<String>();
    public List<String> getFruits() {
        return this.fruits;
    }
}