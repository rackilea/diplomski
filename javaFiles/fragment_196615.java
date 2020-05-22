public class SSHTask implements Runnable {
    private String host;
    private String user;
    private String pass;
    private int port;

    public SSHTask(String host, String user, String pass, int port) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.port = port;
    }

    public void run() {
        sshConnection s = new sshConnection();
        try {
            s.Connection(host,user,pass,port);
        } catch (JSchException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}