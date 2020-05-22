// e.g.
@Override
public void run() {
    while(true){
        TheObject objToDealWith; 
        synchronized (queue) {
            // Only synchronized on queue when fetching task
            objToDealWith = getTask(queue);
        }

        // Process task; independent of queue
        process(objToDealWith);
    }
}