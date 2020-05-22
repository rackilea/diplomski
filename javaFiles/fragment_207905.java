public class Events {
    private static <T> Event<T> create(String name) {
        return () -> name;
    }

    public static final Event<String> EVENT1 = create("Event1");
    public static final Event<String> EVENT2 = create("Event2");
    public static final Event<Long> EVENT3 = create("Event3");
}