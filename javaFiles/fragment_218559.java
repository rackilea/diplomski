public class Player {

  String name;
  private int hitPoints = 250;
  private int str = 10;
  private int att = 10;
  private int def = 10;

  public void strike(Player other){
    other.receiveStrike(str * att);
  }

  private void receiveStrike(int strikePower){
    int hitPoints = hitPoints - computeDamage(strikePower);
  }

  protected int computeDamage(int strikePower){
    return strikePower / this.def;
  }

  public static void main(String[] args){

    Player one = new Player();
    Player two = new Player();

    while (two.hitPoints > 0){
            one.strike(two);
            System.out.println("two's hitpoints: " + two.hitPoints);
    }
  }
}