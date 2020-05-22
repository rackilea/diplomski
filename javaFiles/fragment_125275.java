public class PacketParser implements Runnable {

    private ILogger logger;
    private BlockingQueue<Packet> queue;
    private boolean running = true;

    public PacketParser(ILogger logger, BlockingQueue<Packet> queue) {
        this.logger = logger;
        this.queue = queue;
    }

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            Packet packet;
            try {
                packet = queue.take();
                parse(packet);
            } catch (InterruptedException exception) {
                logger.Log(exception.getStackTrace().toString());
            }
        }
    }