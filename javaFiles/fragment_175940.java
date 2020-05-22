byte[] receiveData = new byte[1024];
DatagramPacket ricevuta= new DatagramPacket(receiveData,receiveData.length);
while(true)
{
    datagramSocket.receive(ricevuta);     //waits here until any packet is received
    String messaggio = (new String(ricevuta.getData()).trim());   
    System.out.println("Client says: " + messaggio);
    Checking();
}