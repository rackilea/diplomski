public class Task {
    public int taskId;
    public int taskPosition; 
}

public void updateDatabase(Task taskToBeUpdated, int newPosition) {

     // You need two update queries. 
     // Update task_table set task_position += task_position + 1 where task_position >= newPosition;
     // Update task_table set task_position = newPosition where taskId = taskTobeUpdated.taskId
}