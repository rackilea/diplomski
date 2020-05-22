public class Thing {
private static Integer TaskId = 0;
public static void main(String .. args) {

     Map<Ineger,Task> tasks = addTask("myName", LocalDate.now()+"", LocalTime.now()+"")
     System.out.println(tasks);
}

private static Map<Integer,Task> addTask(String name, String date, String time) {
    Map<Integer, Task> tasks = new HashMap<>();
    Task newtask = Task (aName,aDate, aTime);
    tasks.put(TaskId,newtask);
    TaskId = TaskId +1; 
    return tasks; // crucial
}
}