class SocketMgr implements Runnable{
final private int timeout=5000;
private Socket s;
public SocketMgr(Socket s){this.s=s;new Thread(this).start();}
public void run(){
try{Thread.sleep(timeout);s.close();}catch(Exception ex){}
}
}