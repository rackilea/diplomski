private List<BlockingQueue<String>> workerQueue= new ArrayList<>();
public QueueThreadPool(int numThreads, int numQueues) {
    this.workerQueue = new ArrayList<>(numQueues);  // <-- initialize the field.
    this.numQueues = numQueues;
    this.numThreads = numThreads;
    ...