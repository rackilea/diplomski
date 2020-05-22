boolean continue = true;
while (continue) {
    synchronized(Manager.queue) {
        while (Manager.queue.peek() == null) {
            Manager.queue.wait();
        }
        Job job=Manager.queue.pop();
    }
}