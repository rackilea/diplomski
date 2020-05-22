public void addPcb(Pcb pcb, String queueName) {
    List<Pcb> queue = queues.get(queueName);
    if (queue != null) {
        queue.add(pcb);
    } else {
        throw new IllegalArgumentException("Queue does not exist: " + queueName);
    }
}