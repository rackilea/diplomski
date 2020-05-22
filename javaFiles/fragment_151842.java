void addWorkItem(int queueIndex, WorkItem workItem) {
    assert queueIndex >= 0 && queueIndex < NUM_PRODUCERS : "Pick a valid number";
    //Note: You may want to make the two operations a single atomic operation
    producers[queueIndex].add(workItem);
    producerProducer.add(producers[queueIndex]);
}