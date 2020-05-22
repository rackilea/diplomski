import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class UDPListener implements Runnable {

    private volatile boolean isRunning;
    private volatile boolean clientClosed;
    private int port;
    private DatagramSocket client;

    public UDPListener(int listeningPort) {
        this.port = listeningPort;
    }

    private void open() throws SocketException {
        System.out.println(getName() + " Opening datagram socket...");
        this.clientClosed = false;
        if (this.client != null) {
            this.client.close();
        }
        this.client = new DatagramSocket(this.port);
        System.out.println(getName() + " Opened datagram socket.");
    }

    @Override
    public void run() {
        System.out.println(getName() + " Starting...");
        try {
            this.open();

            this.isRunning = true;
            this.clientClosed = false;
            final DatagramPacket packet = new DatagramPacket(new byte[256], 256);

            while (this.isRunning) {
                System.out.println(getName() + " Waiting for datagrams...");
                try {
                    this.client.receive(packet);
                } catch (SocketException e) {
                    if (!this.clientClosed) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(getName() + " Interrupted while waiting for datagrams.");
                }
            }
        } catch (SocketException se) {
            se.printStackTrace();
        } finally {
            this.client.disconnect();
            System.out.println(getName() + " Stopped.");
        }
    }

    public void stop() {
        this.isRunning = false;
        this.clientClosed = true;
        this.client.close();
    }

    private static String getName() {
        return "[" + Thread.currentThread().getName() + "]";
    }


    public static void main(String[] args) throws InterruptedException, SocketException {
        System.out.println(getName() + " Started main application.");
        UDPListener t = new UDPListener(0);
        ExecutorService e = Executors.newFixedThreadPool(1);
        // t.open(); easier to debug if this call is exclusively done by UDPListener#run()
        e.submit(t);
        final int sleep = 2000;
        System.out.printf(getName() + " Sleeping for %d\n", sleep);
        Thread.sleep(sleep);
        System.out.printf(getName() + " Slept for %d\n", sleep);
        System.out.println(getName() + " Stopping all threads.");
        t.stop();
        e.shutdownNow();
        System.out.println(getName() + " Stopped main application.");
    }
}