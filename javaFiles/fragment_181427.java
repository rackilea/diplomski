@Component
public class SocketWrapper {
    public HashMap<Integer, Socket> sockets = new HashMap<Integer, Socket>();
    public HashMap<Integer, Socket> getSockets() {
        return sockets;
    }

    public void setSockets(HashMap<Integer, Socket> sockets) {
        this.sockets = sockets;
   }
}