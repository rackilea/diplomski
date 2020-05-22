public class CustomEvent1 extends CustomEvent {

    public static final EventType<CustomEvent> CUSTOM_EVENT_TYPE_1 = new EventType(CUSTOM_EVENT_TYPE, "CustomEvent1");

    private final int param;

    public CustomEvent1(int param) {
        super(CUSTOM_EVENT_TYPE_1);
        this.param = param;
    }

    @Override
    public void invokeHandler(MyCustomEventHandler handler) {
        handler.onEvent1(param);
    }

}