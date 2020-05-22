package my.packagename;

public enum HaltingProblem implements TaskCreator {
    INSTANCE;
    static {
        TaskGroup.IMPOSSIBLE.register(INSTANCE);
        TaskGroup.COOL.register(INSTANCE);
    }

    public Task createTask() {
        Task task = new Task();
        task.setName("Halting problem");
        // and other halting-problem-specific Task setup
        return task;
    }
}