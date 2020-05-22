socket = new Socket();
socket.connect(new InetSocketAddress(host, port), timeout);

// This buffer to receive data from your server  
in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "ISO-8859-1"));
// This one to send
out = socket.getOutputStream();