class Server implements Runnable{
  private final String serverBusyMessage="Error -> Server is busy";
  private ServerSocket ss;
  private static volatile boolean busy=false;
  public static void setFree(){busy=false;}
  public void run(){
    while(true){
       try{Socket s=ss.accept();
           if(busy){//if there is one connection processing.
              ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
              out.writeObject(serverBusyMessage);
              out.flush();
              s.close();continue;
           }
           System.out.println("---------------Aguardando por certidões----------------");   
           new Thread(new Provider(s)).start();
           busy=true;
       }catch(Exception e){}
    }
  }
  private Server(){try{ss=new ServerSocket(2004);}catch(Exception ex){}}
  public static void main(String[] arg){
    Server server = new Server();
    new Thread(server).start();
  }
}