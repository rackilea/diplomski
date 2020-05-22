public class Game {
   public enum Status { PLAYER, COACH };
   private Status status;
   public Game(Status status){
     this.Status = status;
   }

public static void main(String args[]){
     new Game(Status.PLAYER);
     new Game(Status.COACH);
   }
}