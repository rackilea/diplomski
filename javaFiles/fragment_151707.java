class CustomEvent extends Event {

    private String parameter;

    public static final EventType<CustomEvent> CUSTOM = new EventType(ANY, "CUSTOM");
    public CustomEvent(String parameter) {
        super(CustomEvent.CUSTOM);
        this.parameter = parameter;
    }

    public String getParameter() {
        return this.parameter;
    }

}