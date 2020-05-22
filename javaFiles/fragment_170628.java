public PriorityQueue(int maxSize) {
  queues = new Queue[maxSize+1]; 
  size = maxSize;
  for(int i = 0; i <= maxSize; i++) 
    queues[i] = new LinkedList<E>(); 
}