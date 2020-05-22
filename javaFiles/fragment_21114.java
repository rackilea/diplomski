public class Lab2Client {
/**
 * @param args[0] == server name, args[1] == server port, args[2] == myport
 */
public static void main(String[] args) {
    //Serverport is 10085, our client is 10086
    try {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(args[0]);
        int portToSend = Integer.parseInt(args[2]);
        System.out.println("Clent Socket Created");
        byte[] toSend = new byte[5];
        toSend[0] = 0x12; toSend[1] = 0x34;//Code Number
        toSend[2] = 15;//GroupId, f in hex
        toSend[3] = 0x27;toSend[4] = 0x66;
        System.out.println("Byte Array Constructed");

        DatagramPacket sendPacket = new DatagramPacket(toSend, toSend.length, IPAddress, Integer.parseInt(args[1]));
        clientSocket.send(sendPacket);          
        System.out.println("Sent Request. Waiting for reply...\n");

        DataInputStream input = new DataInputStream(echoSocket.getInputStream());
        toRecieve can either be an error message, a return of what we sent,
        or a byte stream full of IP info and port numbers.
        the "heavy" byte stream is either 4 for IPv4 of 16 for IPv6, 2 bytes for port,
        and the magic number (2 bytes) for a total of 9-20 bytes*/

        byte[] toRecieve = new byte[9];
        DatagramPacket receivePacket = new DatagramPacket(toRecieve, toRecieve.length);
        clientSocket.receive(receivePacket);            
        checkMessage(toRecieve);            
    } //and so on and so forth...