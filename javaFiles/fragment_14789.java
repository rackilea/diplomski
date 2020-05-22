public class UdpListener extends Thread
{
    public void run()
    {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket;
        System.out.println("Waiting to receive...");
        DatagramSocket serverSocket;
        try {
            serverSocket = new DatagramSocket(8888);    
            while (true) {
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                //if i receive a packet and it doesn't already have a flow rule process it
                if ((receivePacket != null) ){
                    System.out.println("First byte of received package is: " + receivePacket.getData()[0]);
                }
            }
        } catch (SocketException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}