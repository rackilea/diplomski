public interface ScaleFactory {

    public Scale newInstance();
    public String type();

}

public class FirstScaleFactory implements ScaleFactory {

    public Scale newInstance() {
        return new FirstScale();
    }

    public String type() {
        return "first";
    }    

}

public class SecondScaleFactory implements ScaleFactory {

    public Scale newInstance() {
        return new SecondScale();
    }

    public String type() {
        return "second";
    }    

}

public class ScaleManager {

    private final Map<String, ScaleFactory> factories;

    @Autowired
    public ScaleManager(List<ScaleFactory> factories) {
        this.factories = factories.stream()
            .collect(Collectors.toMap(f -> f.type(), Function::identity));
    }

    public Scale newInstance(String type) {
        return Optional.ofNullable(factories.get(type))
            .map(factory -> factory.newInstance())
            .orElseThrow(IllegalArgumentException::new);
    }

}