public class SomeClass {
    private final SomeResource resource;

    @Inject
    public SomeClass(SomeResource resource) {
        this.resource = resource;
    }
}