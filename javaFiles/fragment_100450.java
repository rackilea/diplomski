/**
 * Defines a high-level task contract. 
 * Let's pretend it is enough to have it this simple.
 */
interface Task extends Runnable {

}

/**
 * Defines a simple way to group dependent tasks.
 * 
 * Please note, this is the simplest way to make sure dependent tasks will be
 * executed in a specified order without any additional overhead.
 */
class CompoundTasks implements Task {

    private List<Task> tasks = ...;

    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public void run() {
        for(Task t : tasks) {
           t.run();
        }
    }        
}