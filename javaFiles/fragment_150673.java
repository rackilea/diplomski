public class UsernameSocketPair{
  private String name;
  private Socket socket;
  public UsernameSocketPair(String name, Socket socket){
     this.name = name;
     this.socket = socket;
  }

  public String getName(){
     return name;
  }

  public Socket socket(){
     return socket;
  }
}