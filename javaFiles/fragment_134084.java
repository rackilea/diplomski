public void run() {
    boolean interrupted = false;
    while (!interrupted) {
        try {
             // or sleep, then queue.put(event)
             queue.take(event); 
        } catch (InterruptedException e) {
            interrupted = true;;
        }
    }
}