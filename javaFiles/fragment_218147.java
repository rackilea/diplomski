public class Worker {
    private static int numWorkers; // Number of Worker objects created
    private int id;                // Individual ID of a worker

    public Worker() {
        id = ++numWorkers; // Will be 1 for the first, 2 for the second, ...
    }

    public int getID() {
        return id;
    }

    public static int getNumWorkers() {
        return numWorkers;
    }
}