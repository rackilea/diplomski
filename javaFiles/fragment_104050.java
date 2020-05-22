public class SocketReader implements Runnable {

    private final InputStream stream;
    private final Queue<String> destination;
    private volatile boolean active = true;

    private SocketReader(InputStream stream, Queue<String> destination) {
        this.stream = stream;
        this.destination = destination;
    }

    public static SocketReader getReader(Socket toRead, Queue<String> destination) throws IOException {
        return new SocketReader(toRead.getInputStream(), destination);
    }

    public void shutdown() {
        active = false;
    }

    public void run() {
        while(active) {
            if (stream.hasNextLine() && active) {
                final String line = stream.nextLine;
                destination.add(line);
            }
        }
        try {
            stream.close();
        } catch (IOException e) {
            // Log somewhere
        }
    }
}