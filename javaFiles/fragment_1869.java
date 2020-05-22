public class EchoServer implements Thread {

    public static BlockingQueue<String> requests = new LinkedBlockingQueue<>();

    public void echo(String s) {
        if(isInterrupted()) throw new IllegalStateException("Queue is closing!");
        requests.add(s);
    }

    @Override
    public void run() {
        try(
            while(!isInterrupted() || requests.peek()!=null)
               processEchoRequest(requests.take());
        } catch (InterruptedException e) {}
    }

    private void processEchoRequest(String s) { /* [...] */ }

}