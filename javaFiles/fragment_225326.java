public class Client {

 private Board board;

  public Client(String s){
   board.convertFromString(s);
  }

 public void setBoard(Board board){
      this.board = board;
 } 

}