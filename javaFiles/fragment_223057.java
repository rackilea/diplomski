public class MyRunnable extends Runnable {

    public void run(){
        try {
           System.out.println("inizializzo il server");
           ss = new ServerSocket(PORT);
           while(true){
               System.out.println("server pronto in ascolto");
               s = ss.accept(); //s is a global Socket object
               ThreadServer newConnection = new ThreadServer();
               newConnection.connect(s);
               System.out.println("connessione stabilita");

               handleConnection(s);
           }
        } catch (IOException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}