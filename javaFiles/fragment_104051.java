public class QueuedPrinter implements Runnable {

    private final Queue<String> input;
    private final PrintStream destination;
    private volatile boolean active;

    public QueuedPrinter(Queue<String> input, PrintStream destination) {
        this.input = input;
        this.destination = destination;
    }

    public void shutdown() {
        active = false;
    }

    public void run() {
        while(active) {
            final String line = input.poll();
            if (line != null && active) {
                destination.println(line);
            }
        }
    }

}