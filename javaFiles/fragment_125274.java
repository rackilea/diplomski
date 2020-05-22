public class Main {

    public static void main(String[] args) {
        BlockingQueue<Packet> queue = new LinkedBlockingQueue<>();
        ILogger logger = Injector.getLogger();

        Thread reader = new Thread(new PacketReader(logger, queue, "239.1.1.1", 49410));
        Thread parser = new Thread(new PacketParser(logger, queue));

        reader.start();
        parser.start();
    }
}