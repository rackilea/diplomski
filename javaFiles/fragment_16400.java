public static void main(String... args) throws IOException {
    final Selector selector = Selector.open();

    //every 10 seconds this thread will go through all the connections and
    //send "(x times) (date) to every client
    new Thread() {
        public void run() {
            for (int i = 0; selector.isOpen(); i++) {
                for (SelectionKey key : selector.keys()) {
                    if (key.channel() instanceof SocketChannel) {
                        ((Queue<ByteBuffer>) key.attachment()).add(ByteBuffer.wrap((i + " - " + new Date() + "\n").getBytes()));
                        key.interestOps(OP_READ | OP_WRITE); //enable write flag
                    }
                }

                selector.wakeup(); //wakeup so it can get to work and begin writing
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
        }
    }.start();


    //create server on port 5050
    ServerSocketChannel server = ServerSocketChannel.open();
    server.configureBlocking(false);
    server.bind(new InetSocketAddress(5050));
    server.register(selector, OP_ACCEPT);

    //reusable buffer
    final ByteBuffer readBuffer = ByteBuffer.allocate(0x1000);

    while (selector.isOpen()) {
        int selected = selector.select();
        System.out.println("Selected " + selected + (selected == 1 ? " key." : " keys."));
        if (selected > 0) {
            for (SelectionKey key : selector.selectedKeys()) {
                if (key.isValid() && key.isReadable()) {
                    System.out.println("Readable: " + key.channel());
                    SocketChannel socket = ((SocketChannel) key.channel());
                    readBuffer.clear();
                    int read = socket.read(readBuffer);
                    if (read == -1) {
                        System.out.println("Socket Closed " + key.channel());
                        socket.close();
                        continue; //socket is closed. continue loop
                    }

                    //we will add what the client sent to the queue to echo it back
                    if (read > 0) {
                        readBuffer.flip();
                        ByteBuffer buffer = ByteBuffer.allocate(readBuffer.remaining());
                        ((Queue<Buffer>) key.attachment()).add(buffer.put(readBuffer).flip());
                        key.interestOps(OP_WRITE | OP_READ); //enable write flag
                    }
                }

                if (key.isValid() && key.isWritable()) {
                    System.out.println("Writable: " + key.channel());
                    SocketChannel socket = (SocketChannel) key.channel();

                    //retrieve attachment(ArrayBlockingQueue<ByteBuffer>)
                    Queue<Buffer> dataToWrite = (Queue<Buffer>) key.attachment();

                    //only remove from queue once we have completely written
                    //this is why we call peek first, and only remove once (buffer.remaining() == 0)
                    for (ByteBuffer buffer; (buffer = (ByteBuffer) dataToWrite.peek()) != null;) {
                        socket.write(buffer);
                        if (buffer.remaining() == 0) dataToWrite.remove();
                        else break; //can not write anymore. Wait for next write event
                    }

                    //once queue is empty we need to stop watching for write events
                    if (dataToWrite.isEmpty()) key.interestOps(OP_READ);
                }

                if (key.isValid() && key.isAcceptable()) {
                    System.out.println("Acceptable: " + key.channel());
                    SocketChannel socket = ((ServerSocketChannel) key.channel()).accept();
                    socket.configureBlocking(false);

                    //add a ArrayBlockingQueue<ByteBuffer> as an attachment for the socket
                    socket.register(selector, OP_READ, new ArrayBlockingQueue<ByteBuffer>(1000));
                }
            }
            selector.selectedKeys().clear(); //must clear all when finished or loop will continue selecting nothing
        }
    }
}