public interface Task {
    int getPriority(); // just for example
    // plus whatever methods define a task
}

public enum Team1Task implements Task {
    Task1(1),
    Task2(3);
    private final int priority;
    private Team1Task(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }
}