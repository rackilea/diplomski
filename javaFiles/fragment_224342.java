public class TestInject {
    ...

    public TestInject() {
        // Needed to inject your dependencies
        ServerComponent component = DaggerServerComponent.builder()
            .build();
        component.inject(this);
    }
    ...
}