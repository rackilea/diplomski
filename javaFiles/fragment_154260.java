class ToDoListEntry {
    String task;
    LocalDate date;
    ToDoListEntry next;

    public ToDoListEntry(LocalDate date, String task) {
       this.task = task;
       this.date = date;
    }
}

public class ToDoList {
    ToDoListEntry first;
    int size;

    public ToDoList (){
        first = null;
        size = 0;
    }

    public void add(ToDoListEntry newTask) {
        if (first == null){
            first = newTask;
        }else{
            ToDoListEntry pointer = first;
            while (pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = newTask;
        }
        size++;
    }

    public String print() {
        String result = "";
        if (first == null) {
            result = "Empty list!\n";
        } else {
            ToDoListEntry pointer = first;
            while (pointer != null) {
                result += "Until " + pointer.date + " Task: " + pointer.task +"\n";
                pointer = pointer.next;
            }
        }
        System.out.println(result);
        return result;
    }
}