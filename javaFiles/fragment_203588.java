@Component
public class MyComponent {

    private final Counter myCounter;

    public MyComponent(MeterRegistry registry) {
        myCounter = Counter
                .builder("mycustomcounter")
                .description("this is my custom counter")
                .register(registry);
    }

    public String countedCall() {
        myCounter.increment();
    }
}