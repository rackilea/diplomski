void addTask(Task task, int i, int j) {
    taskTable[i][j] = task;
}
void config() {
    addTask(new Task(), 1, 1);
}