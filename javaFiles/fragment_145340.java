// create an unconnected socket
Socket soc = new Socket();
soc.setSoTimeout(SO_TIMEOUT); // if you like

// connect (with timeout)
soc.connect(new InetSocketAddress(host, port), CONNECT_TIMEOUT);