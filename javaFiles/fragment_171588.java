// create an unbound socket
DatagramSocket socket = new DatagramSocket(null);

// make it possible to bind several sockets to the same port
socket.setReuseAddress(true);

// might not be necessary, but for clarity
socket.setBroadcast(true);

socket.bind(new InetSocketAddress(9002));