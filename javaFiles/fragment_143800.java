class TimerTask implements Runnable{
private FTPClient client;
public static FTPFile[] files;

public TimerTask(FTPClient client) {
    this.client=client;
    files=null;
    System.out.println("client is Connected: "+client.isConnected());
}
@Override
public void run() {
    PacketHandler tcph = new PacketHandler();
    files=tcph.getFiles(client); // custom get files method(-)
}
}