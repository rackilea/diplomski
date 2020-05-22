import de.greenrobot.event.EventBus;

public class MainTest {
    EventBus eventBus = EventBus.getDefault();

    eventBus.post("This is a test event object");
}