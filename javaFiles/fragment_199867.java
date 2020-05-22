public class TestModule implements VertxModule {

    ...

    @Provides
    public EventBus getEventBus() {
        return vertx.eventBus();
    }
}


public class A() {

    @Inject
    Provider<EventBus> eventBus;

    @GET
    @Path("/foo")
    public String foo() {

        eventBus.get().send("Test-Address", "HELLO");
        return "bar";
    }
}