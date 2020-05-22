public enum TaskStatus {
    TaskCreated(1, "Task Created"), 
    TaskDeleted(2, "Task Deleted");

    private final int value;
    private final String description;

    private TaskStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    // Getters etc

    // Consider overriding toString to return the description
}