import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class ConnectionStatusService extends ScheduledService<Status> {

    // Property allows you to change the "baseUrl" between executions
    private final StringProperty baseUrl = new SimpleStringProperty(this, "baseUrl");

    // property getter and setters omitted...

    @Override
    protected Task<Status> createTask() {
        // creates a new Task and gives the current "baseUrl"
        // as an argument. This is called every cycle
        return new ConnectionStatusTask(getBaseUrl());
    }

    private static class ConnectionStatusTask extends Task<Status> {

        // A Task is a one-shot thing and its initial state should be
        // immutable (or at least encapsulated from external modification).
        private final String baseUrl;

        private ConnectionStatusTask(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        @Override
        protected Status call() throws Exception {
            // Do what you need to determine connection status
            return computedStatus;
        }
    }

}