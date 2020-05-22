@Component
public class MyOtherClass {
    private final MyRequiredService service;

    public MyOtherClass(final MyRequiredService service) {
        this.service = service;
    }

    // Other methods here.
}