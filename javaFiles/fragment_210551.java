public class ArrayQueue {
    /**
     * Array to store queue elements.
     */
    private Object [] queueArray;
    /**
     * Size of above array.
     */
    private int arraySize;
    /**
     * Position in array where next queue element will be inserted.
     */
    private int putPosition;
    /**
     * Position in array from which next queue element will be retrieved.
     */
    private int getPosition;
    /**
     * Current number of elements in queue.
     */
    private int currentSize;
    /**
     * Lock for thread safety.
     */
    private final Object lock = new Object();

    public ArrayQueue(int size){
        if(size <= 0){
            // there must be queue of at least 1 element.
            throw new IllegalArgumentException();
        }

        // initialize other things.
        queueArray = new Object[size];
        arraySize = size;
        putPosition = 0;
        getPosition = 0;
        currentSize = 0;
    }

    /**
     * Inserts element in queue.
     * If queue if full, then waits for queue to make empty room for element to insert.
     * @param object to insert.
     * @throws InterruptedException
     */
    public void put(Object object) throws InterruptedException {
        synchronized (lock) {
            // critical section.

            while(currentSize == arraySize){
                // queue is full, wait for someone to call get() to have empty room in queue.
                lock.wait();
            }

            // we have empty room in queue.

            // insert next element in queue.
            queueArray[putPosition] = object;

            // update position where next element will be inserted.
            putPosition = putPosition + 1;
            if(putPosition == arraySize){
                // we reached end of index bound, wrap index back to 0.
                putPosition = 0;
            }

            // update current size.
            currentSize = currentSize + 1;

            if(currentSize == 1){
                // queue was empty before, invoke any calls if blocked in get().
                lock.notify();
            }
        }
    }

    /**
     * Returns next element from queue.
     * If queue is empty, waits for some element to be added in queue.
     * @return next element.
     * @throws InterruptedException
     */
    public Object get() throws InterruptedException {
        synchronized (lock) {
            // critical section.

            while(currentSize == 0){
                // queue is empty, wait.
                lock.wait();
            }

            // queue is not empty.

            // retrieve next element.
            Object object = queueArray[getPosition];

            // update position from where next element will be retreived.
            getPosition = getPosition + 1;
            if(getPosition == arraySize){
                getPosition = 0;
            }

            if(currentSize == arraySize){
                // queue was full before, invoke any calls if blocked in put().
                lock.notify();
            }

            // update current size.
            currentSize = currentSize - 1;

            // return element.
            return object;
        }
    }

    public int size(){
        synchronized (lock) {
            return currentSize;
        }
    }
}