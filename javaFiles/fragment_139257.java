import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class BgrdService extends ScheduledService<String> {
    @Override protected Task<String> createTask() {
        return new BgrdTask();
    }
}