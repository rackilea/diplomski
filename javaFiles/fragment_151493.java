boolean continue = true;
while (continue) {
    synchronized(Manager.queue) {
        Job job=Manager.queue.pop();
    }
}