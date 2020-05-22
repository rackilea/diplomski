class ReadState {
    final ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
    long count;
}

while (true) {

    // ...

        if (key.isAcceptable()) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            // Attach the read state for this socket
            // to its corresponding key.
            socketChannel.register(selector, SelectionKey.OP_READ,
                new ReadState());
        }

        if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ReadState state = (ReadState) key.attachment();
            ByteBuffer buffer = state.buffer;
            state.count += socketChannel.read(buffer);

            if (state.count >= DATA_LENGTH) {
                socketChannel.close();
            }

            buffer.flip();

            // Caution: The speed of this connection will limit your ability
            // to process the remaining selected keys!
            anotherServerChannel.write(buffer);
        }