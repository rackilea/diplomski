HashMap<TaskKey,Task> taskTable;
void addTask(Task task, int i, int j) {
    taskTable.put(new TaskKey(i,j), task);
}
Task getTask(int i, int j){
    return taskTable.get(new TaskKey(i,j));
}
void config() {
    addTask(new Task(), 1, 1);
}