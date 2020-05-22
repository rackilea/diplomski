import com.google.gwt.user.client.ui.Label;
// ... only relevant imports included
public class MyWidget extends Label {
    private List<MyListener> listeners = new ArrayList<MyListener>();

    public MyWidget() {
        addStyleName("m-my-label");
        // Add GWT event listeners for events that you want to capture.
        addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                notifyListeners();
            }
        });
    }

    private void notifyListeners() {
        for (MyListener listener : listeners) {
            listener.onSomeEvent(new ClientData("Hello from widget"));
        }
    }
}