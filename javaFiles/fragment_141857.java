abstract class Task implements Cloneable {
    int taskData;
    int key1;
    int key2;
    Task(int key1_, int key2_) {
        this.key1 = key1_;
        this.key2 = key2_;
    }
    int getKey1() {
        return key1;
    }
    int getKey2() {
        return key2;
    }
    Task newInstance(int taskData) {
        Task task = (Task) clone();
    task.taskData = taskData;
        return task;
    }
    abstract void doSomething();
}