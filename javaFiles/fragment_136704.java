public class CustomEvent2 extends CustomEvent {

    public static final EventType<CustomEvent> CUSTOM_EVENT_TYPE_2 = new EventType(CUSTOM_EVENT_TYPE, "CustomEvent2");

    private final String param;

    public CustomEvent2(String param) {
        super(CUSTOM_EVENT_TYPE_2);
        this.param = param;
    }

    @Override
    public void invokeHandler(MyCustomEventHandler handler) {
        handler.onEvent2(param);
    }

}