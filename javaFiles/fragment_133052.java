public class MySocket extends Socket {

    public MySocket(String ipAddress, int port){
        super(ipAddress,port);
    }

    public void close(){
        // do nothing
    }

    public void reallyClose(){
        super.close();
    }
}