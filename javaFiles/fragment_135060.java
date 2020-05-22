@WebListener
public class MulticastSender implements ServletContextListener {

private MulticastSocket socket;
private boolean running = true;
private Thread mcss;

public MulticastSender() {
    System.out.println("New " + this.getClass().getSimpleName());
    try {
        socket = new MulticastSocket(MulticastConstants.MULTICAST_PORT);
        mcss = new MulticastServerThread();
    } catch (IOException e) {
        System.out.println("Error creating MulticastSender: " + e.getMessage());
    }
}

@Override
public void contextInitialized(ServletContextEvent sce) {
    System.out.println("Starting " + this.getClass().getSimpleName());
    mcss.start();
}

@Override
public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Stopping " + this.getClass().getSimpleName());
    this.running = false;
    socket.disconnect();
    socket.close();
}

private class MulticastServerThread extends Thread {

    public MulticastServerThread() {
        super("MulticastServer");
    }

    public void run() {

        System.out.println("Start sending multicast packets ...");
        while (running) {
            System.out.println("Sending multicast packet ...");
            try {
                byte[] dataBuffer = MulticastConstants.MULTICAST_PACKET_DATA.getBytes();
                InetAddress group = InetAddress.getByName(MulticastConstants.MULTICAST_CHANNEL);
                DatagramPacket packet = new DatagramPacket(dataBuffer, dataBuffer.length, group, MulticastConstants.MULTICAST_PORT);
                socket.send(packet);
                System.out.println("Packet send ...");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                }
            } catch (IOException e) {
                System.out.println("Error sending multicast packet: " + e.getMessage());
                running = false;
                break;
            }
        }
        socket.close();
    }
}
}