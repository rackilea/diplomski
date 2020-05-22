try { 
      InetAddress addr = InetAddress.getByName("www.google.com");
      int port = 80; SocketAddress sockaddr = new InetSocketAddress(addr, port);
      Socket sock = new Socket(); 
      int timeoutMs = 500; 
      sock.connect(sockaddr, timeoutMs); 
    } 
catch (SocketTimeoutException  e) { System.out.println("Timeout reached!");}