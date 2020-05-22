public class YouSocketClass {
   static public Socket socket = null;
   static public InputStream in = null;
   static public OutputStream out = null;

   public YouSocketClass() {
     super();
   }
   public static final Socket getConnection(final String ip, final int port, final int timeout) {
    try {
        socket = new Socket(ip, port);
        try {
            socket.setSoTimeout(timeout);
        } catch(SocketException se) {
            log("Server Timeout");
        }
        in = socket.getInputStream();
        out = socket.getOutputStream();
    } catch(ConnectException e) {
        log("Server name or server ip is failed. " + e.getMessage());
        e.printStackTrace();
    } catch(Exception e) {
        log("ERROR Socket: " + e.getMessage() + " " + e.getCause());
        e.printStackTrace();
    }
    return socket;
}

public static void closeConnection() {
    try {
        if(socket != null) {
            if(in != null) {
                if(out != null) {
                    socket.close();
                    in.close();
                    out.close();
                }
            }
        }
    } catch(Exception e2) {
        e2.printStackTrace();
    }
}

private static Object log(Object sms) {
    System.out.println("Test Socket1.0: " + sms);
    return sms;
}
}