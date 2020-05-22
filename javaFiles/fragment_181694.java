@Scheduled(cron = "some_time_at_night")
public void runJob() {
    // Query non processed tasks from the database
    List<Task> tasks = database.getNonProcessedTasks();
    // Iterated over returned tasks
    for (Task t : tasks) {
        try {
            // Process current task
            this.process(t);
            // Mark current task as processed in database or delete it
            database.updateTaskAsProcessed(t);
        } catch (Exception ex) {
            // Handle ex, either log it or store it for further reference
        }
    }
}

private void process(Task t) {
    // Perform processing here
}