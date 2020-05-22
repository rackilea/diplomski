void update(List<Task> orderedTask, Task task) {
    int idx = Collections.binarySearch(orderedTask, task);
    if (idx >= 0) {
        orderedTask.set(idx, task);
    } else {
        orderedTask.add(-idx - 1, task);
    }
}