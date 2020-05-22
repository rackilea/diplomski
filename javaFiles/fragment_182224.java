public class MyClass {
    @Inject
    private static EventBus eventBus;
    private static MyClass INSTANCE;

    public static MyClass singleton() {
        if (INSTANCE == null) {
            INSTANCE = new MyClass();
        }
        return INSTANCE;
    }

    private MyClass() {
    }
}