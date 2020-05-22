/**
 * Defines yet another abstraction to make dependencies 
 * visible and properly tracked. 
 * 
 */
abstract class DependentTask implements Task {

    private List<DependentTask> dependencies = ...;

    public void addDependency(DependentTask task) {
        dependencies.add(task);
    }

    /**
     * Verifies task can be processed. 
     */
    public boolean hasDependenciesResolved() {
        boolean result = true;
        for(DependentTask t : dependencies) {
            if(!t.hasDependenciesResolved()) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public abstract void run();
}

/**
 * Implements a very basic queue aware of task dependencies.
 * 
 * Basically, the idea is just to avoid any blocking state. If task can't
 * be processed (because of unresolved dependencies) it should be 
 * postponed and verified later.
 */
class TaskQueue<T extends DependentTask> implements Runnable {        
    private Queue<T> queue = ...;

    @Override
    public void run() {
        while(true) {
            if(!queue.isEmpty()) {

                T task = queue.poll();

                // Verify all dependencies have been resolved.
                if(task.hasDependenciesResolved()) {
                    task.run();         // process task if there is no unresolved
                                        // dependencies
                }else{
                    queue.add(task);    // return task to the queue
                }

            }else{
                // sleep for some reasonable amount of time
            }
        }
    }        
}