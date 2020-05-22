public class Stocker {
private Task task;
private int id;
public Stocker(Task task, int id) {
this.task = task;
this.id = id;
}
public Task getTask() {
return task;
}
public int getId() {
return id;
}
}