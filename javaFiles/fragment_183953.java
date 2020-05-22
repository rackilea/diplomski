public ManagerUdpPacket receive()
{
int receivedBytes = 0;

//receive a packet
DatagramPacket recvPacket = new DatagramPacket(receiveData, receiveData.length);
try{
    receivedBytes = clientSocket.receive(recvPacket);
}catch(IOException e){
    Log.e("ERR", "IOException in UdpReceiver.receive");
    return null;
}
byte[] myObject = new byte[receivedBytes];

for(int i = 0; i < receivedBytes; i++)
{
     myObject[i] = receiveData[i];
}

ManagerUdpPacket obj = deserializeManagerPacket(myObject);

if (obj != null)
    Log.v("udpPacket", "UDP saatu: " + obj.getDriver());
return obj;
}