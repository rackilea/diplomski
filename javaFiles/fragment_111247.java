DatagramSocket workingSocket = ?;//
DatagramPacket sendPacket = null, receivePacket = null;
byte[] sendData = null;
byte[] receiveData = null;

receiveData = new byte[65508]; //NOTE: at least 16 bytes | 65508 is max size, unused bytes are 0
receivePacket = new DatagramPacket(receiveData, receiveData.length);

sendData = this.getRequestTypeAnnounce(announceUDPWrapper.a_TransactionId);
sendPacket = new DatagramPacket(sendData, sendData.length); 
workingSocket.send(sendPacket);
workingSocket.receive(receivePacket);
byte[] fullResponse = receivePacket.getData();