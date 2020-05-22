import org.reactfx.EventStream;
import org.reactfx.EventStreamBase;
import org.reactfx.Subscription;

public class MyTable extends TableView {
    public MyTable () {

        // Since you are using some custom event dispatching mechanism,
        // the first step is to convert that into a ReactFX EventStream.
        EventStream<MyEvent> events = new EventStreamBase<MyEvent>() {
            @Override protected Subscription observeInputs() {
                MyListener l = event -> notifyObservers(event);
                Events.addListener(l);
                return () -> Events.removeListener(l);
            }
        };

        // Now the interesting part: events will not be observed whenever
        // this MyTable is not part of a showing Window.
        events.conditionOnShowing(this).subscribe(event -> this.handleEvent(Event));
    }

    private void handleEvent(MyEvent) {
        /* ... */
    }
}