public class Test{

  public static void main(String args[])
  {     
    new PlayerPaddle().receiveEvent();
  }
}
abstract class Actor {
  public void releasedEvent(KeyEvent e) {
  }
}
abstract class Paddle extends Actor {
  public void moveDown() { // this method is called
      System.out.println("paddle");
  }
}
class PlayerPaddle extends Paddle {
  @Override
  public void moveDown() { // this method never gets called
   System.out.println("playerpaddle");
  } 
  public void receiveEvent() {
     this.moveDown(); // Want to call moveDown() inside PlayerPaddle      
  }
}