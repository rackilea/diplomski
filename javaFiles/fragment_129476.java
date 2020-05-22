try {
        InetAddress addr = InetAddress.getByName("java.sun.com");
        int port = 80;
        SocketAddress sockaddr = new InetSocketAddress(addr, port);

        // Create an unbound socket
        Socket sock = new Socket();

        // This method will block no more than timeoutMs.
        // If the timeout occurs, SocketTimeoutException is thrown.
        int timeoutMs = 2000;   // 2 seconds
        sock.connect(sockaddr, timeoutMs);
    } catch (UnknownHostException e) {
    } catch (SocketTimeoutException e) {
    } catch (IOException e) {
    }