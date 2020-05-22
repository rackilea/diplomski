// some import
import javax.enterprise.event.Event;

@Singleton
@Startup
public class TimerBean {

    @Inject
    private Event<TickEvent> tickEvent;

    @Schedule(hour = "*", minute = "*", second = "*/5")
    public void printSchedule() {
        tickEvent.fire(new TickEvent(/*...your initialization...*/));
    }

    public class TickEvent{
        // we have some info here but you can 
        // leave it empty.
    }

}