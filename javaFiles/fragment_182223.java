public class MyClass {
    @Inject
    MyClass(EventBus eventBus) {
        this.eventBus = eventBus;   
    }
}