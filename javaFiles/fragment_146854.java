public class ListBoxBEvent extends GwtEvent<ListBoxBChanged.Handler> {

    public interface Handler extends EventHandler {
        void onListBoxBChanged(ListBoxBEvent listBoxBEvent);
    }

    public static final GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();
    private Object selectedObject;

    public VueChangedEvent(Object selectedObject) {
        this.selectedObject=selectedObject;
    }

    @Override
    public GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }
    @Override
    protected void dispatch(Handler handler) {
        handler.onListBoxBChanged(this);
    }

    public static HandlerRegistration register(EventBus eventBus, Handler handler) {
        return eventBus.addHandler(TYPE, handler);
    }

    public Object getSelectedObject(){
        return selectedObject;
    }

}