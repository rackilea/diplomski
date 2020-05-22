public PriorityQueueArray<E> clone() {
    PriorityQueueArray<E> answer;
    answer.manyItems = manyItems;
    answer.highest = highest;
    answer.queues = new ArrayQueue<E>[queues.length]; // This is the key!
    for (int i = 0; i <= highest; i++) {
        answer.queues[i] = queues[i].clone();
    }   
    return answer;
}