package my.packagename;

public enum PerformAddition implements TaskCreator {
    INSTANCE;
    static {
        TaskGroup.EASY.register(INSTANCE);
        TaskGroup.COOL.register(INSTANCE);
    }

    public Task createTask() {
        Task task = new Task();
        task.setName("Perform addition");
        // and other addition-specific Task setup
        return task;
    }
}