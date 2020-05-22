public class SocketManager extends JFrame implements Runnable {
    public ClientSwing cs = new ClientSwing();
....

public class ClientSwing extends JFrame implements Runnable {
    public SocketManager socketmanager = new SocketManager();