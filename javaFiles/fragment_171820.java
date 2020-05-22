Task task = new Task(args...); //put real args in actual code
//do stuff

public void onButtonPress(){
    SubTask subtask = new SubTask(args...); //put real args in actual code
    task.addSubTask(subtask);
}