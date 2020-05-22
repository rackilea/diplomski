public class MulticastServerThread extends QuoteServerThread {

private long FIVE_SECONDS = 5000;

public MulticastServerThread() throws IOException {
    super("MulticastServerThread");
}

public void run() {
    while (moreQuotes) {
        try {
            byte[] buf = new byte[256];

                // construct quote
            String dString = null;
            if (in == null)
                dString = new Date().toString();
            else
                dString = getNextQuote();
            buf = dString.getBytes();

            InetAddress group = InetAddress.getByName("255.255.255.255"); //Keep this as the same multicast ip as in your client
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);


            try {
                sleep((long)(Math.random() * FIVE_SECONDS));
            } catch (InterruptedException e) { }
        } catch (IOException e) {
            e.printStackTrace();
            moreQuotes = false;
        }
    }
    socket.close();
}