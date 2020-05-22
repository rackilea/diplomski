DatagramSocket socket = new DatagramSocket(9999); 
 DatagramPacket requestPacket = new DatagramPacket(inBuf, inBuf.length);
 // will be blocked until a request is received by the server
 socket.receive(requestPacket); 
 // the client's port and ip address will be populated in the packet on receiving a request.
 DatagramPacket responsePacket = new DatagramPacket(outBuf, outBuf.length, requestPacket.getAddress(), requestPacket.getPort());
 // the data will be sent to the client.
 socket.send(responsePacket);