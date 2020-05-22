void update2(List<Task> orderedTask, Task task) {
    var idx = orderedTask.indexOf(task);
    if(idx >= -1) {
        orderedTask.remove(idx);
        orderedTask.add(idx, task);
    }
    else {
        orderedTask.add(-idx - 1, task);
    }
}