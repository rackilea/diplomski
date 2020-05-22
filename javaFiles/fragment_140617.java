if(selectedKey.isAcceptable()) {
            //Handle a new connection request
            System.out.println(name + ": Got an OP_ACCEPT key");
            final ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectedKey.channel();
            SocketChannel connection = null;
            try {
                connection = serverSocketChannel.accept();
                connection.configureBlocking(false);

                final InetSocketAddress connectionAddress = (InetSocketAddress)connection.getRemoteAddress();
                final String remotePeerIp = connectionAddress.getAddress().getHostAddress();
                final int remotePeerPort = connectionAddress.getPort();

                final PwpPeer pwpConnection = new PwpPeer(remotePeerIp, remotePeerPort);

                connection.register(selectedKey.selector(), SelectionKey.OP_READ, pwpConnection);
                System.out.println(name + ": Accepted remote connection: ip: " + remotePeerIp + ", port " + remotePeerPort);
            } catch (final IOException ioe) {
                System.err.println(name + ": Failed to accept incoming connection: " + ioe.getMessage());
                if(connection != null) {
                    connection.close();
                }
            }
        }