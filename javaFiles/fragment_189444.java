InetAddress addr = InetAddress.getByName("127.0.0.1");
// or
InetAddress addr = InetAddress.getByName("::1");

// and now you can pass it to your socket-constructor
ServerSocket sock = new ServerSocket(1234, 50, addr);