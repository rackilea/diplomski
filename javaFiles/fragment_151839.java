try {
    dsock = new DatagramSocket();
    byte[] buf = new byte[1000];
    DatagramPacket dpack = new DatagramPacket(buf, buf.length);

    //...

    dsock.setSoTimeout(1000);   // set the timeout in millisecounds.

    while(true) {        // recieve data until timeout
        try {
             System.out.println("Receiving message...");
             dsock.receive(dpack); // receive the packet
             System.out.println("Message received");
        }
        catch (SocketTimeoutException e) {
            // timeout exception.
            System.out.println("Timeout reached!!! " + e);
            dsock.close();
        }
    }
catch (SocketException e) {
    System.out.println("Socket closed " + e);

}