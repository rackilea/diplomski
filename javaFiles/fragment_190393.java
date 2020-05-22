{
    Task task = new Task();
    task.copy(in, out);
}

{
    Task task = new Task(in, out);
    task.copy();
}

{
    Task task = Task.createTask();
    task.copy(in, out)
}

{
    Task task = Task.createTask(in, out);
    task.copy();
}