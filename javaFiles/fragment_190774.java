// any free port will be assigned by os
DatagramSocket clientSocket = new DatagramSocket(); 
// create a packet to be sent ot server
DatagramPacket requestPacket = new DatagramPacket(outBuf, outBuf.length, serverAddress, 9999);
// sending the packet to udp server 
clientSocket.send(requestPacket); 

DatagramPacket responsePacket = new DatagramPacket(inBuf, inBuf.length)
// client will be blocked until a response is sent by server
clientSocket.receive(responsePacket);