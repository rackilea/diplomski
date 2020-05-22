/**
* Takes a <code>Set</code> of Process IDs and notifies all listeners when all
* of them have exited.<br>
*/
public class ProcessGroupExitWatcher extends Thread {
    private List<HANDLE> processHandles;
    private List<ProcessExitListener> listeners = new ArrayList<ProcessExitListener>();

    /**
     * Initializes the object and takes a set of pids and creates a list of
     * <CODE>HANDLE</CODE>s from them.
     *
     * @param processIds
     *           process id numbers of the processes to watch.
     * @see HANDLE
     */
    public ProcessGroupExitWatcher(Set<Integer> processIds) {
        processHandles = new ArrayList<HANDLE>(processIds.size());
        //create Handles from the process ids
        for (Integer pid : processIds) {
            processHandles.add(Kernel32.INSTANCE.OpenProcess(Kernel32.SYNCHRONIZE, false, pid)); //synchronize must be used
        }
    }

    public void run() {
        //blocks the thread until all handles are signaled
        Kernel32.INSTANCE.WaitForMultipleObjects(processHandles.size(), processHandles.toArray(new HANDLE[processHandles.size()]), true,
            Kernel32.INFINITE);
       for (ProcessExitListener listener : listeners) {
            listener.processFinished();
       }
    }

    /**
     * Adds the listener to the list of listeners who will be notified when all
     * processes have exited.
     *
     * @param listener
     */
     public void addProcessExitListener(ProcessExitListener listener) {
         listeners.add(listener);
     }

    /**
     * Removes the listener.
     * 
     * @param listener
     */
    public void removeProcessExitListener(ProcessExitListener listener) {
         listeners.remove(listener);
    }
}