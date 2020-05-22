import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class ReaderThread extends Thread {

    private DatagramChannel channel;

    public ReaderThread(DatagramChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer packet = ByteBuffer.allocate(65536);
            while (true) {
                packet.clear();
                if (channel.receive(packet) != null) {
                    packet.flip();
                    int remaining = packet.remaining();
                    byte[] b = new byte[remaining];
                    packet.get(b, 0, remaining);
                    System.out.println(new String(b, StandardCharsets.UTF_8));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class WriterThread extends Thread {
    private SocketAddress target;
    private DatagramChannel channel;

    public WriterThread(DatagramChannel channel, int othersPort, String othersIp) {
        super();
        this.target = new InetSocketAddress(othersIp, othersPort);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ByteBuffer buf = ByteBuffer.allocate(48);
                buf.clear();
                buf.put("Hello world!".getBytes(StandardCharsets.UTF_8));
                buf.flip();
                channel.send(buf, target);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        int portA = 1091;
        String machineA = "localhost";// "10.101.2.40";
        int portB = 1092;
        String machineB = "localhost";// "10.101.2.39";

        DatagramChannel channelA = DatagramChannel.open();
        channelA.socket().bind(new InetSocketAddress(portA));
        channelA.configureBlocking(false);
        ReaderThread readerA = new ReaderThread(channelA);
        WriterThread writerA = new WriterThread(channelA, portB, machineB);
        readerA.start();
        writerA.start();

        DatagramChannel channelB = DatagramChannel.open();
        channelB.socket().bind(new InetSocketAddress(portB));
        channelB.configureBlocking(false);
        ReaderThread readerB = new ReaderThread(channelB);
        WriterThread writerB = new WriterThread(channelB, portA, machineA);
        readerB.start();
        writerB.start();
    }
}