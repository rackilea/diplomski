private final DatagramSocket udpSocket;
private volatile boolean closed; // or AtomicBoolean
...

public synchronized void start() throws IOException {
    if (closed) {
        throw new IOException("Closed");
    }
    new Thread(new Runnable() {
        @Override
        public void run() {
            final byte[] buffer = new byte[1024];
            final DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            Throwable error = null;

            try {
                while(true) {            
                    udpSocket.receive(dp);
                    final String message = new String(buffer, 0, dp.getLength());
                    System.out.println(message);
                }
            } catch (Throwable t) {
                if (!closed) {
                    error = t;
                }
            }
            if (error != null) {
                // do some work for error
            }
        }
    }).start();
}

public void close() throws IOException {
    synchronized(this) {
        if (closed) return;
        closed = true;
    }
    udpSocket.close();
}