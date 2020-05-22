DatagramPacket request = new DatagramPacket(buffer, buffer.length);
  datagramSocket.receive(request);
  byte [] sendMessage = (request.getData() + " Server Processed").getBytes();
  DatagramPacket reply = new DatagramPacket(sendMessage,
                         sendMessage.length, request.getAddress(), request.getPort());
  datagramSocket.send(reply);