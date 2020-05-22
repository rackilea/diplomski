public class SourceFileConsumer implements Runnable {
    private String endMarker;
    …

    public SourceFileConsumer(LinkedBlockingQueue<String> buffer, String endMarker, 
            ServerSocket serverSocket, Socket client, long checkpoint[], int rate[]) {
        this.buffer = buffer;
        this.endMarker = endMarker;
…

                    line = buffer.take();
                    if(line==endMarker) break;