ChannelDirectTCPIP channel = (ChannelDirectTCPIP)gateway.openChannel("direct-tcpip");
channel.setHost(host);
channel.setPort(port);
// important: first create the streams, then connect.
InputStream iStream = channel.getInputStream();
OutputStream oStream = channel.getOutputStream();
channel.connect();

// now write to oStream and read from iStream