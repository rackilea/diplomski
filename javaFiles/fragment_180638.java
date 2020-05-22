if(this.serverChannel != null && this.serverChannel.isOpen()) {

    try {

        this.serverChannel.close();

    } catch (IOException e) {

        log.error("Exception while closing server socket");
    }
}

try {

    Iterator<SelectionKey> keys = this.selector.keys().iterator();

    while(keys.hasNext()) {

        SelectionKey key = keys.next();

        SelectableChannel channel = key.channel();

        if(channel instanceof SocketChannel) {

            SocketChannel socketChannel = (SocketChannel) channel;
            Socket socket = socketChannel.socket();
            String remoteHost = socket.getRemoteSocketAddress().toString();

            log.info("closing socket {}", remoteHost);

            try {

                socketChannel.close();

            } catch (IOException e) {

                log.warn("Exception while closing socket", e);
            }

            key.cancel();
        }
    }

    log.info("closing selector");
    selector.close();

} catch(Exception ex) {

    log.error("Exception while closing selector", ex);
}