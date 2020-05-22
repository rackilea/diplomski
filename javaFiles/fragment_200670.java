public class Game {
  private static Player Anfallare, Forsvarare; //  <-- you define them here, so they are available to any method in the class

  public static void main(String[] args) {

    Anfallare = new Player("A");  //  <-- it is already defined as a Player, so now you only need to instantiate it
    Forsvarare = new Player("F");
    MotVarandra(Anfallare.getDice(1), Forsvarare.getDice(1));
    // ...
  }
  public static void MotVarandra(int a, int f){
    if(f >= a){
        Anfallare.armees-=1; //  <-- it is already defined and instantiated
    }else{
        Forsvarare.armees-=1;
    }
  }
}