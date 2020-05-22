while (true) {
  DatagramPacket request = new DatagramPacket(buffer, buffer.length);
  datagramSocket.receive(request);
  String [] arrayMsg= (new String(request.getData())).split(" ");
  byte [] sendMessage=(arrayMsg[i]+"  Server Processed").getBytes();
  DatagramPacket reply=new DatagramPacket(sendMessage,sendMessage.length,request.getAddress(),
    request.getPort());
  datagramSocket.send(reply);
  i++;
  }
}