public abstract class MyCustomEventHandler implements EventHandler<CustomEvent> {

    public abstract void onEvent1(int param0);

    public abstract void onEvent2(String param0);

    @Override
    public void handle(CustomEvent event) {
        event.invokeHandler(this);
    }
}