public class SourceFileProducer implements Runnable {
    private String endMarker;
    …
    public SourceFileProducer(LinkedBlockingQueue<String> buffer, 
            String endMarker, String fileName) {
        this.buffer = buffer;
        this.endMarker = endMarker;
    …

    @Override
    public void run() {
        System.out.println("SourceFileProducer thread-" + Thread.currentThread().getId()
            + " initiating with source file: " + fileName);
        String line;
        try {
            while((line = reader.readLine()) != null) buffer.put(line);
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }
        buffer.put(endMarker);
    }