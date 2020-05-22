public class SDServerThread extends Thread {

    protected MulticastSocket socket = null;
    ...
    socket = new MulticastSocket(2);
    ...
    socket.joinGroup(group);

}