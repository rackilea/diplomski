private BlockingQueue<Integer> queue;

    public SharedSpace(BlockingQueue<Integer> queue) {
        super();
        this.queue = queue;
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void addValue(int value)
    {
        try {
            queue.put(value);
            System.out.println(System.nanoTime()+" Producer added value "+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getValue() throws InterruptedException
    {
            return queue.take();


    }