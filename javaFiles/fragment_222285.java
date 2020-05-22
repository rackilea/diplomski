public class Demo2B {
  public static void main(String[] args) throws SocketException {
    DatagramSocket sendSocket = new DatagramSocket();
    DatagramSocket receiveSocket = new DatagramSocket(8805);  //Set the Demo2B will use port 8805 to receive data
    new Thread(new send(sendSocket)).start();
// This sould be new Thread(new receive(receiveSocket)).start();
    new Thread(new send(receiveSocket)).start();
}